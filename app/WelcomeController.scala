package controllers

import javax.inject.Inject

import play.api.mvc.{Action, Controller}
import views.GreetingService

class WelcomeController @Inject() (greeter: GreetingService) extends Controller {
  def welcome() = Action {
      val greeting = greeter.greeting
      Ok(views.html.welcome(greeting))
  }
}
