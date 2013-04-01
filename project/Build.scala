import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName = "myCricketApp"
    val appVersion = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "com.github.twitter" % "bootstrap" % "2.0.2",
      "org.mongodb" %% "casbah-core" % "2.5.0",
      "com.novus" %% "salat-core" % "1.9.2-SNAPSHOT",
      "org.scalatra" %% "scalatra-json" % "2.2.0",
  	  "org.json4s"   %% "json4s-jackson" % "3.1.0"
      
    )

  val main = play.Project(appName, appVersion, appDependencies).settings(

    resolvers ++= Seq(
      "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases",
      "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
      "webjars" at "http://webjars.github.com/m2"
    )
  )
}