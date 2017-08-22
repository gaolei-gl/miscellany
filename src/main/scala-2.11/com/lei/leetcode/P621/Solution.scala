package com.lei.leetcode.P621

import scala.collection.immutable.Stack
import scala.collection.mutable

case class Tree(topic: String, questions: Seq[String], subTopic: Seq[Tree]) {
  override def hashCode() = topic.hashCode

  override def equals(obj: scala.Any) = {
    obj match {
      case Tree(x, _, _) => this.topic == x
      case _ => false
    }
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
  def getQueries: Seq[Query] = {
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
  def getQuestions = {
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
    val root = Tree("root", empty[String], empty[Tree])
    val questionGroupByTopic = getQuestions
    val queries = getQueries

    //    val tree = buildTree(root, flattenTreeStr, 0, questionGroupByTopic)
    //    println(tree)
  }

  def buildTree(flattenTree: String, questionGroupByTopic: Map[String, IndexedSeq[String]]) = {
    val words = flattenTree.split(" ")
    var stack = mutable.ListBuffer[Tree]()
    val root = Tree("root", empty[String], empty[Tree])
    var current = root
    words.foreach {
      _ match {
        case "(" => stack += Tree("(", empty[String], empty[Tree])
        case ")" =>
          while (stack.length != 0 && stack.last != "(") {
            names :+ stack.last
            stack = stack.init
          }
          if (stack.length != 0) {
            stack = stack.init
            val birds = stack.last
            stack = stack.init
            val children = names.map(topicName => Tree(topicName, questionGroupByTopic.getOrElse(topicName, empty[String]), empty[Tree]))
            Tree(birds, empty[String], children)
          }


        case topic => stack += Tree(topic, empty[String], empty[Tree])
      }
    }
  }


  //  def buildTree(currentRoot: Tree, str: String, questionGroupByTopic: Map[String, Seq[String]]): Tree = {
  //    val piece = str.takeWhile(_ != ' ').trim
  //    piece match {
  //      case x if x == '(' =>
  //        val index = str.indexOf('(')
  //        val a = str.substring(0, index).trim.split(' ').last
  //        val newTree = buildTree(Tree(a, empty[String], empty[Tree]), str.substring(index + 1).trim, questionGroupByTopic)
  //        currentRoot.copy(subTopic = currentRoot.subTopic :+ newTree)
  //      case x if x == ')' => currentRoot
  //      case topicName =>
  //        currentRoot.copy(subTopic = currentRoot.subTopic :+ Tree(topicName, questionGroupByTopic.getOrElse(topicName, empty[String]), empty[Tree]))
  //    }
  //  }
}


/**
  * 6
  * Animals ( Reptiles Birds ( Eagles Pigeons Crows ) )
  * 5
  * Reptiles: Why are many reptiles green?
  * Birds: How do birds fly?
  * Eagles: How endangered are eagles?
  * Pigeons: Where in the world are pigeons most densely populated?
  * Eagles: Where do most eagles live?
  * 4
  * Eagles How en
  * Birds Where
  * Reptiles Why do
  * Animals Wh
  */