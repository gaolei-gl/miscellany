package com.lei.finatra.thrift.Server

import com.google.inject.Module
import com.lei.finatra.thrift.Controller.BinaryThriftController
import com.twitter.finatra.thrift.ThriftServer
import com.twitter.finatra.thrift.routing.ThriftRouter
import com.twitter.finatra.thrift.modules.ClientIdWhitelistModule
import com.twitter.conversions.time._
import com.twitter.finagle.service.TimeoutFilter
import com.twitter.finatra.thrift.filters._

/**
  * Created by Lei on 2016/10/14.
  */

object FinatraThriftServerMain extends FinatraThriftServer


class FinatraThriftServer extends ThriftServer {


  override protected def modules: Seq[Module] = Seq(
    ClientIdWhitelistModule
  )

  override protected def configureThrift(router: ThriftRouter): Unit = {
    router
      .filter[StatsFilter]
      .add[BinaryThriftController]
  }

}
