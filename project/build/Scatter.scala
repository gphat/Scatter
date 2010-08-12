import sbt._

class ScatterProject(info: ProjectInfo) extends DefaultWebProject(info) {

    override def webappPath = "webapp"
}