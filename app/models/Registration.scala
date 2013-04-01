package models

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.commons.ValidBSONType.BasicDBList
import com.novus.salat._
import com.novus.salat.global._
import com.mongodb.casbah.Imports._
import com.novus.salat.annotations._
import mongoContext._

//Class for the tournament
case class Tournaments(tournamentName: String, location: String, teams: String, tournamentFormat: String) {}

//Class for the team
case class Teams(teamName: String, roster: String) {}

//Class for the roster
case class Roster(playerName: String, playerSkill: String) {}

//Object for tournamnet with supported operation as:
// all --> Get the list of all the tournaments
// create --> Create a new tournament
// TODO: Create a operation to search tournament by name
object Tournaments {
  val registerTournaments = MongoConnection()("myCricketApp")("tournaments")
  
  val temp = Tournaments(tournamentName = "IPL")
  def all = registerTournaments.map(grater[Tournaments].asObject(temp)).toList
  
  def create(tournaments: Tournaments) {
    registerTournaments += grater[Tournaments].asDBObject(tournaments)
  }
}

//Object for teams with supported operation as:
// all --> Get the list of all the teams
// create --> Create a new team
// TODO: Create a operation to search team by name
object Teams {
  val registerTeams = MongoConnection()("myCricketApp")("teams")
  
  def all = registerTeams.map(grater[Teams].asObject(_)).toList
  
  def create(teams: Teams) {
    registerTeams += grater[Teams].asDBObject(teams)
  }
}

//Object for roster with supported operation as:
// all --> Get the list of all the rosters
// create --> Create a new roster
object Roster {
  val registerPlayer = MongoConnection()("myCricketApp")("roster")
  
  def all = registerPlayer.map(grater[Roster].asObject(_)).toList
  
  def create(roster: Roster) {
    registerPlayer += grater[Roster].asDBObject(roster)
  }
}
