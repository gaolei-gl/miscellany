package com.lei.DI

/**
  * Created by Lei on 2017/6/17.
  */
trait SimulationEntity {
  def handleMessage(msg: String, ctx: String): Unit
}

trait NetworkEntity {
  def getMacAddress(ip: String): String

  def hasIpAddress(addr: String): Boolean


  def handleMessage(msg: String, ctx: String): Unit = msg match {
    case "1" =>
//    case _ => super.handleMessage(msg, ctx)
  }
}

