package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import models._

//Tournament object
object Register extends Controller {

	//Index for tournament registration
	def index1 = Action { implicit request =>
	    Ok(views.html.registerTournament(tournamentRegistrationForm))
	}
	
	//Index for team registration
	def index2 = Action { implicit request =>
	    Ok(views.html.registerTeam(teamRegistrationForm))
	}
	
	//Index for roster registration
	def index3 = Action { implicit request =>
	    Ok(views.html.registerRoster(rosterRegistrationForm))
	}
	
  //Tournament registration form
  def tournamentRegistrationForm = Form(
    mapping(
      "tournamentName" -> nonEmptyText,
      "location" -> nonEmptyText,
      "teams" -> nonEmptyText,
      "tournamentFormat" -> nonEmptyText
    )(Tournaments.apply)(Tournaments.unapply)
  )

  //Team registration form
  def teamRegistrationForm = Form(
    mapping(
      "teamName" -> nonEmptyText,
      "roster" -> nonEmptyText
    )(Teams.apply)(Teams.unapply)
  )
  
  //Roster registration form
  def rosterRegistrationForm = Form(
    mapping(
      "rosterName" -> nonEmptyText,
      "playerSkill" -> nonEmptyText
    )(Roster.apply)(Roster.unapply)
  )
  
  //Create a new tournament
  def registerTournament = Action { implicit request =>
    tournamentRegistrationForm.bindFromRequest.fold(
      form => BadRequest(views.html.registerTournament(form)),
      tournaments => {
        Tournaments.create(tournaments)
        Redirect(routes.Application.index()).flashing("message" -> "Tournament Registered!")
      }
    )
  }
  
  //Create a new team
  def registerTeam = Action { implicit request =>
    teamRegistrationForm.bindFromRequest.fold(
      form => BadRequest(views.html.registerTeam(form)),
      teams => {
        Teams.create(teams)
        Redirect(routes.Application.index()).flashing("message" -> "Team Registered!")
      }
    )
  }
  
  //Create a new roster
  def registerRoster = Action { implicit request =>
    rosterRegistrationForm.bindFromRequest.fold(
      form => BadRequest(views.html.registerRoster(form)),
      roster => {
        Roster.create(roster)
        Redirect(routes.Application.index()).flashing("message" -> "Roster Registered!")
      }
    )
  }
}