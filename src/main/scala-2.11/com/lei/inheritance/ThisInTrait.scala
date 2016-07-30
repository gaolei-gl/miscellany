package com.lei.inheritance

/**
  * Created by Lei on 16/7/29.
  */
import org.slf4j.LoggerFactory

trait Father {
  val name = this.getClass.getName
}

object ThisInTrait extends Father {
  val logger = LoggerFactory.getLogger(getClass)
  def main(args: Array[String]): Unit = {
    logger.debug(name)
  }
}
