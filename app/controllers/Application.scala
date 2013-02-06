package controllers

import play.api._
import data.Form
import play.api.data.Forms._
import play.api.mvc._
import models.Toot
import java.util.Date

object Application extends Controller {

  val tootForm = Form(
    "message" -> nonEmptyText
  )
  
  def index = Action {
    val toots = Toot.all()
    Ok(views.html.index(toots, tootForm))
  }

  def newToot = Action { implicit request =>
    tootForm.bindFromRequest.fold(
      errors => BadRequest(views.html.index(Toot.all(), tootForm)),
      success => {
        val message: String = success
        Toot.add(message)
        Redirect(routes.Application.index)
      }
    )

    Redirect(routes.Application.index)
  }
  
}