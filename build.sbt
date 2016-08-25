name := "JvmCodeCamp"

version := "1.0"

scalaVersion := "2.11.8"

organization := "com.xiaotunza"

version := "0.1.0"

resolvers ++= Seq(
  Resolver.mavenLocal,
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots"),
  "softprops-maven" at "http://dl.bintray.com/content/softprops/maven"
)

libraryDependencies ++= Seq(
  "commons-io" % "commons-io" % "2.5",
  "redis.clients" % "jedis" % "2.8.1",
  "com.twitter" % "finagle-http_2.11" % "6.35.0" exclude("com.google.guava", "guava"),
  "com.github.finagle" % "finch-core_2.11" % "0.10.0",
  "com.typesafe.akka" % "akka-actor_2.11" % "2.3.15",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.7.3",
  "commons-codec" % "commons-codec" % "1.10",
  "com.google.code.gson" % "gson" % "2.7",
  "com.google.guava" % "guava" % "19.0",
  "org.scala-lang" % "scala-compiler" % "2.11.8",
  "org.scala-lang" % "scala-library" % "2.11.8",
  "io.circe" % "circe-core_2.11" % "0.5.0-M2",
  "io.circe" % "circe-generic_2.11" % "0.5.0-M2",
  "io.circe" % "circe-parser_2.11" % "0.5.0-M2",
  "org.apache.kafka" % "kafka_2.11" % "0.9.0.1" exclude("io.netty", "*") exclude("log4j", "log4j") exclude("org.slf4j", "*"),
  "org.mongodb" % "casbah_2.11" % "3.1.1" pomOnly(),
  "org.json4s" % "json4s-native_2.11" % "3.4.0",
  "ch.qos.logback" % "logback-classic" % "1.1.7",
  "ch.qos.logback" % "logback-core" % "1.1.7",
  "ch.qos.logback" % "logback-access" % "1.1.7",
  "com.chuusai" %% "shapeless" % "2.3.1",
  "me.lessis" %% "courier" % "0.1.3"

)
