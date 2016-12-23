package com.lei.thrift

import com.twitter.finagle.Thrift
import com.twitter.util.{Await, Future}
import com.xiaotunza.thrift.BinaryService

/**
  * Created by Lei on 16/9/27.
  */
object BinaryThriftClient extends App {
  // collect参数是具有相同类型Future的一个集合，返回一个Future，其类型是包含那个类型值的一个序列。
  // 当所有的Future都成功完成或者当中任何一个失败，都会使这个Future完成。返回序列的顺序和传入序列的顺序相对应。

  // join参数是混合类型的Future序列，返回一个Future[Unit]，当所有的相关Future完成时（无论他们是否失败）该Future完成。
  // 其作用是标识一组异构操作完成。对那个内容和广告的例子来说，这可能是一个很好的解决方案。

  // 当传入的Future序列的第一个Future完成的时候，select会返回一个Future。它会将那个完成的Future和其它未完成的Future一起放在Seq中返回。
  // (它不会做任何事情来取消剩余的Future。你可以等待更多的回应，或者忽略他们)

  val client = Thrift.client.newIface[BinaryService[Future]]("localhost:9091")


}
