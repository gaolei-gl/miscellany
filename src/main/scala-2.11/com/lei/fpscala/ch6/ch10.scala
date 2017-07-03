package com.lei.fpscala.ch6

/**
  * Created by Lei on 2017/5/23.
  */


trait Monoid[A] {
  def id: A

  def op(a1: A, a2: A): A
}

class StringMonoid extends Monoid[String] {
  override def id: String = ""

  override def op(a1: String, a2: String): String = a1 + a2
}

object ch10 extends App {
  def foldMap[A, B](as: List[A], m: Monoid[B])(f: A => B): B = {
    as.foldLeft(m.id)((b, a) => m.op(b, f(a)))
  }

  def foldMapV[A, B](as: IndexedSeq[A], m: Monoid[B])(f: A => B): B = {
    as.length match {
      case x: Int if x >= 2 => (foldMapV(as.take(as.length / 2), m)(f) :: foldMapV(as.drop(as.length / 2), m)(f) :: Nil).foldLeft(m.id)(m.op)
      case _ => foldMap(as.toList, m)(f)
    }
  }


  println(foldMapV(IndexedSeq(4, 1, 2, 3, 5, 7, 6), new StringMonoid)(x => (x + 1).toString))

}
