package com.lei.generic

/**
  * Created by Lei on 2017/3/27.
  */

trait Input[Out] {
  def computed: Out
}

case class MultipleRequest(x: Int, y: Int) extends Input[MultipleResponse] {
  override def computed: MultipleResponse = MultipleResponse(x * y)
}

case class MultipleResponse(x: Int)


