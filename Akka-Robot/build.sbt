scalaVersion := "2.9.1"

name := "Akka Training"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

{
val akkaVersion = "2.0-RC1"
libraryDependencies ++= Seq("com.typesafe.akka" % "akka-actor" % akkaVersion, 
                            "com.typesafe.akka" % "akka-remote" % akkaVersion,
                            "com.typesafe.akka" % "akka-kernel" % akkaVersion,
                            "com.typesafe.akka" % "akka-slf4j" % akkaVersion,
                            "com.typesafe.akka" % "akka-testkit" % akkaVersion)
}

libraryDependencies += "org.scalatest" %% "scalatest" % "1.6.1" % "test"

libraryDependencies += "junit" % "junit" % "4.5" % "test"

scalacOptions += "-deprecation" //We use this to make sure we are not using any deprecated features


