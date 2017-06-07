package controllers

import javax.inject.Inject

import play.api.mvc.{Action, Controller}
import views.welcome.SandwichService

/**
  * Created by digital127596 on 07/06/17.
  */
class SandwichController @Inject()(sandwichService: SandwichService) extends Controller{
  def sandwiches() = Action {
    val sandwiches = sandwichService.sandwiches
    Ok(views.html.sandwiches(sandwiches))
  }
}




