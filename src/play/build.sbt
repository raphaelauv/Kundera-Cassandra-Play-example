
name := """play-scala-starter-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)


resolvers += Resolver.sonatypeRepo("snapshots")

resolvers ++= Seq(
	"Kundera" at "https://oss.sonatype.org/content/repositories/releases",
	"Riptano" at "http://mvn.riptano.com/content/repositories/public",
	"Kundera missing" at "http://kundera.googlecode.com/svn/maven2/maven-missing-resources",
	"Scale 7" at "https://github.com/s7/mvnrepo/raw/master"

)


scalaVersion := "2.12.4"



libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += "com.h2database" % "h2" % "1.4.196"
libraryDependencies += "com.impetus.kundera.client" % "kundera-cassandra" % "3.6"
libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "4.3.4.Final"