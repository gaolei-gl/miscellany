package com.lei.akka

import akka.actor.ActorSystem
import akka.actor.SupervisorStrategy.{Directive, Resume}
import scala.concurrent.duration._

/**
  * Created by Lei on 2017/5/8.
  */


import akka.actor._

object Register {

  sealed trait Article

  case object Espresso extends Article

  case object Cappuccino extends Article

  case class Transaction(article: Article)

}

class Register extends Actor with ActorLogging {

  import Register._
  import Barista._

  var revenue = 0
  val prices = Map[Article, Int](Espresso -> 150, Cappuccino -> 250)

  def receive = {
    case Transaction(article) =>
      val price = prices(article)
      sender ! createReceipt(price)
      revenue += price
      log.info(s"Revenue incremented to $revenue cents")
  }

  val decider: PartialFunction[Throwable, Directive] = {
    case _: PaperJamException => Resume
  }


  override def supervisorStrategy: SupervisorStrategy = OneForOneStrategy(10, 60 seconds) {
    decider orElse SupervisorStrategy.defaultDecider
  }


  override def postRestart(reason: Throwable) {
    super.postRestart(reason)
    log.info(s"Restarted because of ${reason.getMessage}")
  }

  //  def createReceipt(price: Int): Receipt = Receipt(price)
  def createReceipt(price: Int): Receipt = {
    import scala.util.Random
    if (Random.nextBoolean())
      throw new PaperJamException("OMG, not again!")
    Receipt(price)
  }
}


object Barista {

  case object EspressoRequest

  case object ClosingTime

  case class EspressoCup(state: EspressoCup.State)

  object EspressoCup {

    sealed trait State

    case object Clean extends State

    case object Filled extends State

    case object Dirty extends State

  }

  case class Receipt(amount: Int)

}

class Barista extends Actor {

  import Barista._
  import Register._
  import EspressoCup._
  import context.dispatcher
  import akka.util.Timeout
  import akka.pattern.ask
  import akka.pattern.pipe
  import concurrent.duration._

  implicit val timeout = Timeout(4.seconds)
  val register = context.actorOf(Props[Register], "Register")

  def receive = {
    case EspressoRequest =>
      val receipt = register ? Transaction(Espresso)
      receipt.map((EspressoCup(Filled), _)).pipeTo(sender)
    case ClosingTime => context.stop(self)
  }
}

object Customer {

  case object CaffeineWithdrawalWarning

}

class Customer(coffeeSource: ActorRef) extends Actor with ActorLogging {

  import Customer._
  import Barista._
  import EspressoCup._

  def receive = {
    case CaffeineWithdrawalWarning => coffeeSource ! EspressoRequest
    case (EspressoCup(Filled), Receipt(amount)) =>
      log.info(s"yay, caffeine for ${self}!")
  }
}

class PaperJamException(msg: String) extends Exception(msg)

object CoffeeShopMain {
  def main(args: Array[String]): Unit = {
    import Customer._
    val system = ActorSystem("Coffeehouse")
    val barista = system.actorOf(Props[Barista], "Barista")
    val customerJohnny = system.actorOf(Props(classOf[Customer], barista), "Johnny")
    val customerAlina = system.actorOf(Props(classOf[Customer], barista), "Alina")
    customerJohnny ! CaffeineWithdrawalWarning
    customerAlina ! CaffeineWithdrawalWarning
    //    system.shutdown()
  }

}
