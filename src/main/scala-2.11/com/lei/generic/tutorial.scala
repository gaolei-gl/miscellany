package com.lei.generic

import java.util.Properties

/**
  * Created by Lei on 16/9/3.
  */
object tutorial {
  def main(args: Array[String]): Unit = {
  }


}

trait Processable[A] {
  type B

  def apply(in: A): B
}


object Processable {
  type Aux[In, Out] = Processable[In] {type B = Out}
  implicit val add: Aux[AddRequest, AddResponse] = new Processable[AddRequest] {
    override type B = AddResponse

    override def apply(in: AddRequest) = {
      AddResponse(in.a + in.b)
    }
  }

  implicit val upper: Aux[UpperCaseRequest, UpperCaseResponse] = new Processable[UpperCaseRequest] {
    type B = UpperCaseResponse

    override def apply(in: UpperCaseRequest): UpperCaseResponse = UpperCaseResponse(in.s.toUpperCase)
  }

}


case class AddRequest(a: Int, b: Int)

case class AddResponse(result: Int)

case class UpperCaseRequest(s: String)

case class UpperCaseResponse(s: String)
