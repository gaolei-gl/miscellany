package com.lei.mail


import scala.util.{Failure, Success}


/**
  * Created by Lei on 16/8/25.
  */
object sendMailByCourier {
  def main(args: Array[String]): Unit = {
    import courier._
    import courier.Defaults._
    val mailer = Mailer("smtp.gmail.com", 587)
      .auth(true)
      .as("gaoleimisc@gmail.com", "PASS WORD")
      .startTtls(true)()

    val resp = mailer(Envelope.from("gaoleimisc" at "gmail.com")
      .to("105092314" at "qq.com")
      .subject("Alert")
      .content(Text("hi mom")))

    resp onComplete {
      case Success(x) => println("message delivered")
      case Failure(e) => println(e)
    }
    // todo the main thread need to keep alive until the future is completed
    Thread.sleep(1000*10)
  }
}
