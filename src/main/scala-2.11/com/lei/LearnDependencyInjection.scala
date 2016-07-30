package com.lei

/**
  * Created by Lei on 16/6/17.
  */

trait FooAble {
  def foo(): String
}

trait MyFooAble extends FooAble {
  def foo() = "foo impl"
}

object LearnDependencyInjection {
  def main(args: Array[String]) {
    val a = new MyFooAble {}
    println(a.foo())
  }
}
