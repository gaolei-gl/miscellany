package com.lei.finatra.thrift.Controller

import com.twitter.finatra.thrift.Controller
import javax.inject.Singleton

import com.twitter.finagle.Service
import com.xiaotunza.thrift.BinaryService
import com.xiaotunza.thrift.BinaryService.FetchBlob

/**
  * Created by Lei on 2016/10/14.
  */

@Singleton
class BinaryThriftController extends Controller with BinaryService.BaseServiceIface {
  override def fetchBlob: Service[FetchBlob.Args, FetchBlob.Result] = ???
}
