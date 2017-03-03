package com.lei.finatra.thrift.server

import com.lei.finatra.thrift.controller.FinatraThriftEchoDemoController
import com.twitter.finagle.ThriftMux.Server
import com.twitter.finatra.thrift.ThriftServer
import com.twitter.finatra.thrift.filters.{AccessLoggingFilter, LoggingMDCFilter}
import com.twitter.finatra.thrift.routing.ThriftRouter


/**
  * Created by Lei on 2016/10/14.
  */

class FinatraThriftServer extends ThriftServer {

  override protected def configureThriftServer(server: Server): Server = {
    server.withAdmissionControl
      .concurrencyLimit(20000, 500)
  }

  override protected def configureThrift(router: ThriftRouter): Unit = {
    router
      .filter[AccessLoggingFilter]
      .filter[LoggingMDCFilter]
      .add[FinatraThriftEchoDemoController]
  }

}

object FinatraThriftServerMain extends FinatraThriftServer

