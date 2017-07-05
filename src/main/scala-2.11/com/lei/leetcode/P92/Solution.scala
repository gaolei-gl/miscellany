package com.lei.leetcode.P92

import scala.collection.immutable

/**
  * Created by Lei on 2017/7/4.
  */

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution extends App {
  val node = new ListNode(1)
  node.next = new ListNode(2)
  node.next.next = new ListNode(3)
  //  node.next.next.next = new ListNode(4)
  //  node.next.next.next.next = new ListNode(5)

  var r = reverseBetween(node, 1, 3)
  while (r != null) {
    println(r.x)
    r = r.next
  }


  def reverseBetween(head: ListNode, m: Int, n: Int): ListNode = {
    var p: ListNode = head
    var cache = List.empty[ListNode]
    (1 until m).foreach(_ => p = p.next)
    (m to n).foreach(
      _ => {
        cache = cache :+ p
        p = p.next
      }
    )
    cache.zip(cache.map(_.x).reverse).map(x => x._1.x = x._2)
    return head
  }
}
