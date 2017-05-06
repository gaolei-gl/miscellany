package com.lei.logback

import org.slf4j.LoggerFactory

/**
  * Created by Lei on 2017/5/4.
  */
class Logback2 {


  private val logger = LoggerFactory.getLogger(classOf[Logback2])

  def log() = logger.debug("in logback2")

}
