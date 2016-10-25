package com.lei.finatra.thrift.Controller

import com.xiaotunza.service.thrift.BinaryService
import com.xiaotunza.service.thrift.BinaryService._

import com.twitter.finatra.thrift.Controller
import com.twitter.util.Future
import javax.inject.Singleton

/**
  * Created by Lei on 2016/10/14.
  */

@Singleton
class BinaryThriftController extends Controller with BinaryService.BaseServiceIface {
  override def add = handle(Add) { args: Add.Args =>
    Future(args.a + args.b)
  }
}
