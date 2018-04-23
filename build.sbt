scalaVersion := "2.12.4"

resolvers += Resolver.mavenLocal

//val slickVersion = "3.3.0-SNAPSHOT"
val slickVersion = "3.2.3"

libraryDependencies += "com.typesafe.slick" %% "slick" % slickVersion
libraryDependencies += "com.typesafe.slick" %% "slick-hikaricp" % slickVersion
libraryDependencies += "com.typesafe.slick" %% "slick-codegen" % slickVersion
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.18"


libraryDependencies += "org.joda" % "joda-convert" % "1.9.2"
libraryDependencies += "net.logstash.logback" % "logstash-logback-encoder" % "4.11"

libraryDependencies += "com.netaporter" %% "scala-uri" % "0.4.16"
libraryDependencies += "net.codingwell" %% "scala-guice" % "4.1.1"

libraryDependencies += "com.typesafe.play" %% "play-json-joda" % "2.6.0"

libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.8.0-beta2"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.13"