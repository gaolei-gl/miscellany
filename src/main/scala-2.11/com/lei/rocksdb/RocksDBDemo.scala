package com.lei.rocksdb

import java.nio.charset.Charset

import org.rocksdb.{Options, RocksDB}

/**
  * Created by Lei on 2017/5/12.
  */
object RocksDBDemo {
  def main(args: Array[String]): Unit = {
    RocksDB.loadLibrary()
    val options = new Options().setCreateIfMissing(true)
    val db = RocksDB.open("./rocksdb/")
    //    db.put("ddd".getBytes, "aaa".getBytes)
    val a = db.get("ddd".getBytes)
  }
}
