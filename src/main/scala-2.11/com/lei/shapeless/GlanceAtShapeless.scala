package com.lei.shapeless


import com.google.common.collect.BiMap
import shapeless.{Generic, HMap, HNil, Id, Poly1}
import shapeless.poly._

case class User(name: String)

case class UserWithAge(name: String, age: Int)

case class Address(street: String, city: String, postcode: String)

case class Person(name: String, age: Int, address: Address)


/**
  * Created by Lei on 16/8/15.
  */

object plusOne extends Poly1 {
  implicit def caseInt =
    at[Int] {
      _ + 1
    }

  implicit def caseString =
    at[String] {
      _ + "1"
    }

  implicit def caseUser =
    at[User] { case User(name) =>
      User(name + "1")
    }
}

object GlanceAtShapeless {
  def main(args: Array[String]): Unit = {
    val demo = 42 :: "Hello" :: User("Julien") :: HNil
    val demoAfterMap = demo.map(plusOne)
    val gen = Generic[UserWithAge]
    val hlist = gen.to(UserWithAge("gaolei", 29))
    import shapeless.syntax.std.tuple._
    (1, "one", 1.0).tail

    println(choose(Set(1, 2, 3)))
    println(choose(Set()))
    println(pairFunction(choose)(Set(11, 22, 33)))
    val sets = Set(1) :: Set("abc") :: HNil
    println(sets map choose)
    val l = 1 :: "foo" :: 3.0 :: HNil
    println((2, "two", 2.0) map option)

    implicit val intToString = new BiMap[Int, String]
    implicit val stringToInt = new BiMap[String, Int]
    implicit val stringToUser = new BiMap[User, UserWithAge]
    val map = HMap[BiMap](0 -> "not ok", "ok" -> 1)
    val nmap = map + (User("gaolei"), UserWithAge("gaolei", 29))
    println(nmap.get(User("gaolei")))


    import shapeless._;
    import syntax.singleton._;
    import record._
    val book =
      ("author" ->> "Benjamin Pierce") ::
        ("title" ->> "Types and Programming Languages") ::
        ("id" ->> 262162091) ::
        ("price" ->> 44.11) ::
        HNil
    book.keys.toList.foreach(println)
    val a = gen.to(UserWithAge("gaolei", 110))


  }

  object option extends (Id ~> Option) {
    override def apply[T](f: Id[T]): Option[T] = Option(f)
  }

  def pairFunction[T](f: Set ~> Option)(s: Set[T]) = {
    f(s)
  }

  object choose extends (Set ~> Option) {
    override def apply[T](f: Set[T]): Option[T] = {
      f.headOption
    }
  }

}

class BiMap[K, V]


