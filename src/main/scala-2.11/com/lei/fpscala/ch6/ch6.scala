//package com.lei.fpscala.ch6
//
///**
//  * Created by Lei on 2017/5/14.
//  */
//sealed trait RNG {
//  def nextInt: (Int, RNG)
//}
//
//
//case class SimpleRNG(seed: Long) extends RNG {
//  override def nextInt: (Int, RNG) = {
//    val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
//    val nextRNG = SimpleRNG(newSeed)
//    val n = ((newSeed) >>> 16).toInt
//    (n, nextRNG)
//  }
//
//}
//
//
//object ch6 extends App {
//
//  /**
//    * 返回 0 和Int.MaxValue之间(含)的随机数
//    *
//    * @param rng
//    * @return
//    */
//  def nonNegativeInt(rng: RNG): (Int, RNG) = {
//  }
//
//}
