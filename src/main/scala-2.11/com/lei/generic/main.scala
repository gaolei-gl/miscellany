package com.lei.generic

import com.lei.generic.Processable._

/**
  * Created by Lei on 2017/3/27.
  */
object main {
  def process[I](i: I)(implicit p: Processable[I]): p.Out = p(i)

  def process2[O](in: Input[O]): O = in.computed

  def main(args: Array[String]): Unit = {
    val sum = AddRequest(10, 15)
    val upper = UpperRequest("haliluya")
    println(process(sum))
    println(process(upper))
    println(process2(MultipleRequest(10, 14)))

  }

}
