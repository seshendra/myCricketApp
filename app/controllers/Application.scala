package controllers

import play.api._
import play.api.mvc._
import models._
import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Writes._

object Application extends Controller {

	//Welcome page with the list of all the tournaments
  	def index = Action { implicit request =>
    	Ok(views.html.index(Tournaments.all))
  	}
  	
  	//Action to get the list of all the tournaments
  	def tournaments() = Action {
  		val tournamentList = (Tournaments.all)
		Ok(Json.toJson(tournamentList.map(tournament => Json.toJson(tournament))))
	}
  	
  	//Action to get the list of all the teams
  	def teams() = Action {
  		val teamList = (Teams.all)
		Ok(Json.toJson(teamList.map(team => Json.toJson(team))))
  	}
  	
  	implicit val writeTournamentData = Json.writes[Tournaments]
	implicit val writeTeamData = Json.writes[Teams]
  	
}