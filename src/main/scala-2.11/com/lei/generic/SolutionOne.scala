package com.lei.generic


/**
  * Created by Lei on 16/9/3.
  */

case class AddRequest(x: Int, y: Int)

case class AddResponse(x: Int)


case class UpperRequest(x: String)

case class UpperResponse(x: String)


trait Processable[In] {
  type Out

  def apply(i: In): Out
}

object Processable {
  type Aux[I, O] = Processable[I] {type Out = O}

  implicit val add: Aux[AddRequest, AddResponse] = new Processable[AddRequest] {
    type Out = AddResponse

    def apply(request: AddRequest) = {
      AddResponse(request.x + request.y)
    }
  }

  implicit val upper: Aux[UpperRequest, UpperResponse] = new Processable[UpperRequest] {
    type Out = UpperResponse

    def apply(request: UpperRequest) = {
      UpperResponse(request.x.toUpperCase)
    }
  }

}
