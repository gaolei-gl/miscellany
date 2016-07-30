package com.lei.akka

import akka.actor.{Actor, ActorSystem, Props}
import akka.actor.Actor.Receive

/**
  * Created by Lei on 16/6/15.
  */
object ActorHierarchy {
  def main(args: Array[String]) {
    val system = ActorSystem("CustomSystem")
    (0 to 5).map(_.toString).map(system.actorOf(Props[ParentActor], _))

  }

}


class ParentActor extends Actor {

  @scala.throws[Exception](classOf[Exception])
  override def preStart(): Unit = {
    println(s"Start actor ${self}")
    super.preStart()
  }

  val child = context.actorOf(Props[ChildActor], "ChildActor")

  override def receive: Receive = {
    case _ =>
  }
}

class ChildActor extends Actor {
  override def receive: Receive = {
    case _ =>

  }
}