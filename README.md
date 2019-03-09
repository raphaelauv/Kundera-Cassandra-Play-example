# Kundera Cassandra Play example

powered by :

- [Impetus Kundera](https://github.com/Impetus/Kundera)

- [Apache Cassandra](https://github.com/apache/cassandra)

- [Play playframework](https://github.com/playframework/playframework) (scala web framework)


## 1) [Ready running Example](./example)

- unzip the file and follow the readme inside

## 2) Build dev env :

- [Download the exemple project from the website of play](https://www.playframework.com/getting-started)
- Insert/replace all the files inside the folder src/play in the exemple project folder

- Follow the instruction inside the fodler doc to installe the database : Utiliser_Framwork_KUNDURA.md

- Launch cassandra database
- go inside the foder of the exemple project downloaded beofre
- Launch : sbt run

the website is accesible by : [localhost:9000](http://localhost:9000)


## test of AKKA
```
scalac  -classpath "*jar:../lib/*" TestAkka.scala
scala  -classpath "*jar:../lib/*" TestAkka.scala
```


