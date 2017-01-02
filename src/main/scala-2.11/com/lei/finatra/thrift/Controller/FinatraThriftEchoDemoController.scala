package com.lei.finatra.thrift.Controller

import java.util.concurrent.atomic.AtomicLong

import com.twitter.finagle.Service
import com.twitter.finatra.thrift.Controller
import com.twitter.util.{Future, SynchronizedLruMap}
import com.xiaotunza.thrift.EchoService
import com.xiaotunza.thrift.EchoService.Echo
import com.xiaotunza.thrift.EchoService.GetCnt

class FinatraThriftEchoDemoController extends Controller with EchoService.BaseServiceIface {
  var a: AtomicLong = new AtomicLong(0l)
  val cache = new SynchronizedLruMap[String, String](50000)

  override val echo: Service[Echo.Args, Echo.Result] = handle(Echo) {
    str: Echo.Args => {
      a.incrementAndGet()
      Future {
        str._1 + "this is from the Server"
      }
    }
  }

  override val getCnt: Service[GetCnt.Args, GetCnt.Result] = handle(GetCnt) {
    args: GetCnt.Args => {
      info("jaa")
      Future(a.get())
    }
  }
}
