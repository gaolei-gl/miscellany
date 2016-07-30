package com.lei

/**
  * Created by Lei on 16/4/7.
  */
object utils {

  /**
    * Encode an object into a JSON string. This method accepts any type T where
    *   T => null | Boolean | String | Number | Map[String, T] | Array[T] | Iterable[T]
    * Any other type will result in an exception.
    *
    * This method does not properly handle non-ascii characters.
    */
  def encode(obj: Any): String = {
    obj match {
      case null => "null"
      case b: Boolean => b.toString
      case s: String => "\"" + s + "\""
      case n: Number => n.toString
      case m: Map[_, _] =>
        "{" +
          m.map(elem =>
            elem match {
              case t: Tuple2[_, _] => encode(t._1) + ":" + encode(t._2)
              case _ => throw new IllegalArgumentException("Invalid map element (" + elem + ") in " + obj)
            }).mkString(",") +
          "}"
      case a: Array[_] => encode(a.toSeq)
      case i: Iterable[_] => "[" + i.map(encode).mkString(",") + "]"
      case other: AnyRef => throw new IllegalArgumentException("Unknown arguement of type " + other.getClass + ": " + other)
    }
  }

}
