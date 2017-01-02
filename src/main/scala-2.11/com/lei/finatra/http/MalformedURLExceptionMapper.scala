package com.lei.finatra.http

import java.net.MalformedURLException
import javax.inject.{Inject, Singleton}

import com.twitter.finagle.http.{Request, Response}
import com.twitter.finatra.http.exceptions.ExceptionMapper
import com.twitter.finatra.http.response.ResponseBuilder

/**
  * Created by lei on 16-12-31.
  */

@Singleton
class MalformedURLExceptionMapper @Inject()(response: ResponseBuilder) extends ExceptionMapper[MalformedURLException] {
  override def toResponse(request: Request, throwable: MalformedURLException): Response = response.badRequest("haha")
}
