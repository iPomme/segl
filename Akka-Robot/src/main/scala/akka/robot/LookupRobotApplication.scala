package akka.robot

import akka.kernel.Bootable
import com.typesafe.config.ConfigFactory
import akka.pattern.ask
import akka.util.Timeout
import akka.util.duration._
import akka.dispatch.Await
import akka.actor.ActorSystem

object RobotClient {

  def main(args: Array[String]) {
    val robotClient = new LookupRobotApplication

    robotClient `... Implement your code here`


    robotClient.shutdown()
  }

}


class LookupRobotApplication extends Bootable {
  val remoteIP = "127.0.0.1"
  val remoteUrl = "akka://SeglRemote@%s:2552/user/seglRobotServer".format(remoteIP)
  val clientContext = ActorSystem("LookupApplication", ConfigFactory.load.getConfig("seglLookup"))

  val log = clientContext.log
  implicit val timeout = Timeout(60 seconds)


  def startup() {}

  def shutdown() {
    clientContext.shutdown()
  }


  def `... Implement your code here` = {
    println("""Use one of the following messages:
            Any Position:
                  - ! ("Say", "AnyThing")
                  - ! "OpenLeftHand"
                  - ! "CloseLeftHand"
                When Sit:
                  - ? "StandUp"
                  - ? "Sit_Drive
                  - ? "Sit_CatchFly
                  - ? "Sit_Puppet
                  - ? "Sit_Pong
           When Stand up:
                  - ? "Sit"
                  - ? "Stand_NoGoodRobot
                  - ? "Stand_R2D2
                  - ? "Stand_Mystic
                  - ? "Stand_Drink
                  - ? "Stand_Laugh"
    """)
  }
}
