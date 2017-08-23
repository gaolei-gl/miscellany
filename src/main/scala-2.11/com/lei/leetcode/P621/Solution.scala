package com.lei.leetcode.P621

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

case class Tree(topic: String, questions: Seq[String], subTopic: Seq[Tree]) {
  override def hashCode() = topic.hashCode

  override def equals(obj: scala.Any) = {
    obj match {
      case Tree(x, _, _) => this.topic == x
      case _ => false
    }
  }

  def select(topic: String) = {
    subTopic.filter(_ == Tree(topic, Seq.empty[String], Seq.empty[Tree])).head
  }
}

case class Query(topic: String, queryString: String)

object Solution {
  val reader = scala.io.StdIn

  def empty[T]: Seq[T] = Seq.empty[T]

  /**
    * read queries
    *
    * @return
    */
  def readQueries: Seq[Query] = {
    val queryCnt = reader.readInt() //  4
    (0 until queryCnt).map {
      _ =>
        val p = reader.readLine().split(" ", 2).map(_.trim)
        Query(p(0), p(1))
    }
  }


  /**
    * form topic question mapping
    *
    * @return
    */
  def readQuestions = {
    val questionCnt = reader.readInt() // 5
    (0 until questionCnt).map {
      _ =>
        val p = reader.readLine().split(":")
        (p(0).trim, p(1).trim)
    }.groupBy(_._1).mapValues(_.map(_._2))
  }

  def main(args: Array[String]): Unit = {
    val n = reader.readInt() // 6
    val flattenTreeStr = reader.readLine() // Animals ( Reptiles Birds ( Eagles Pigeons Crows ) )
    val (root, index) = buildTree(flattenTreeStr, readQuestions)
    System.err.println("Finish build tree and index.")
    readQueries.foreach {
      query: Query => {
        val reversePath = mutable.ListBuffer.empty[String]
        var currentPosition = query.topic
        while (currentPosition != "root") {
          reversePath += currentPosition
          currentPosition = index.get(currentPosition).get
        }
        val path = reversePath.reverse.toList
        val node = findNode(root, path)
        println(matchQuestion(node, query.queryString))
      }
    }

  }

  def matchQuestion(root: Tree, q: String): Int = {
    @tailrec
    def loop(subNodes: List[Tree], acc: Int): Int = {
      subNodes match {
        case head :: tail =>
          val n = head.questions.filter(_.startsWith(q)).length
          loop(head.subTopic.toList ::: tail, n + acc)
        case Nil => acc
      }
    }

    loop(root.subTopic.toList, root.questions.filter(_.startsWith(q)).length)
  }

  @tailrec
  def findNode(root: Tree, path: List[String]): Tree = {
    path match {
      case head :: tail => findNode(root.select(head), tail)
      case Nil => root
    }
  }

  def buildTree(flattenTree: String, questionGroupByTopic: Map[String, IndexedSeq[String]]): (Tree, mutable.Map[String, String]) = {
    val words = flattenTree.split(" ")
    var stack = mutable.ListBuffer[Tree]()
    val LEFTBRACKET = Tree("(", empty[String], empty[Tree])
    val indexes = collection.mutable.Map.empty[String, String]

    words.foreach {
      _ match {
        case "(" => stack += Tree("(", empty[String], empty[Tree])
        case ")" =>
          val tmp = ListBuffer.empty[Tree]
          while (stack.length != 0 && stack.last != LEFTBRACKET) {
            tmp += stack.last
            stack = stack.init
          }
          stack = stack.init
          val last = stack.last
          // mark index
          tmp.foreach { x => indexes += (x.topic -> last.topic) }
          val birds = last.copy(subTopic = tmp)
          stack = stack.init :+ birds
        case topic => stack += Tree(topic, questionGroupByTopic.getOrElse(topic, empty[String]), empty[Tree])
      }
    }
    stack.foreach {
      x => indexes += (x.topic -> "root")
    }
    (Tree("root", empty[String], stack), indexes)
  }


}