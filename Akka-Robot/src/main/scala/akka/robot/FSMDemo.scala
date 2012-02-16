package akka.robot

import akka.actor.{Props, ActorSystem, Actor}


class FSMDemo extends Actor {
  // Needed for the become

  import context._

  def sit: Receive = {
    case "Sit_Drive" => println("OK")
    case "Sit_CatchFly" => println("OK")
    case "Sit_Puppet" => println("OK")
    case "Sit_Pong" => println("OK")
    case "StandUp" => become(stand)
    case _ => println("I'm sit position, your message is out of context")
  }

  def stand: Receive = {
    case "Stand_NoGoodRobot" => println("OK")
    case "Stand_R2D2" => println("OK")
    case "Stand_Mystic" => println("OK")
    case "Stand_Drink" => println("OK")
    case "Stand_Laugh" => println("OK")
    case "Sit" => become(sit)
    case _ => println("I'm standing up, your message is out of context")
  }

  def unknown: Receive = {
    case "Sit" ⇒
      become(sit)
    case "StandUp" ⇒
      become(stand)
    case _ => println("I'm in a unknown state")

  }


  def receive = unknown

}

object FSM {
  val system = ActorSystem()

  def main(args: Array[String]) {
    val actor = system.actorOf(Props[FSMDemo], "FSMDemo")
    actor ! "Dummy"
    actor ! "Sit"
    actor ! "Dummy"
    actor ! "Sit_Pong"
    actor ! "StandUp"
    actor ! "Dummy"
    actor ! "Sit_Pong"
    actor ! "Stand_R2D2"


  }
}