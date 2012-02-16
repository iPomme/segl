package akka.robot

import akka.actor.{Props, ActorSystem, Actor}


class FSMDemo extends Actor {
  // Needed for the become
  import context._

  protected def receive = null
}

object FSM {
  val system = ActorSystem()

  def main(args: Array[String]) {
    val actor = system.actorOf(Props[FSMDemo], "FSMDemo")
  }
}
