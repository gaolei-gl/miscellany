package com.lei.leveldb

import org.iq80.leveldb._
import org.iq80.leveldb.impl.Iq80DBFactory._
import java.io._

/**
  * Created by lei on 17-1-4.
  */
object LevelDBDemo {
  def main(args: Array[String]): Unit = {
    val options = new Options()
      .createIfMissing(true)
    val db: DB = factory.open(new File("example"), options)
    try {
      db.put("aaa".getBytes, "value aaa".getBytes)
      db.put(bytes("Tampa"), bytes("rocks"))
      val value = asString(db.get(bytes("Tampa")))
      db.delete(bytes("Tamapa"))
    } finally {
      db.close()
    }
  }

}
