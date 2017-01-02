package com.lei.finatra.http

import com.twitter.finagle.http.{Request, Response}
import com.twitter.finagle.{Service, SimpleFilter}
import com.twitter.util.Future

/**
  * Created by lei on 16-12-31.
  */
case class User(id: Int)

class FinatraDemoRequestScopeFilter extends SimpleFilter[Request, Response] {
  override def apply(request: Request, service: Service[Request, Response]): Future[Response] = {
    UserContext.setUser(request)
    service(request)
  }

}

object UserContext {
  private val UserField = Request.Schema.newField[User]()

  implicit class UserContextSyntax(val request: Request) extends AnyVal {
    def user: User = request.ctx(UserField)
  }

  private[http] def setUser(request: Request) = {
    val id = request.getIntParam("id")
    val user = User(id)
    request.ctx.update(UserField, user)
  }
}
