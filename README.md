# Kundera Cassandra Play example

powered by :

- [Impetus Kundera](https://github.com/Impetus/Kundera)

- [Apache Cassandra](https://github.com/apache/cassandra)

- [Play playframework](https://github.com/playframework/playframework) (scala web framework)


## 1) [Ready running Example](./example)

- unzip the file and follow the readme inside

video example :

<a href="https://user-images.githubusercontent.com/10202690/54074487-33e85280-4293-11e9-9071-4d9b467200e9.gif" target="_blank"><img src="https://user-images.githubusercontent.com/10202690/54074487-33e85280-4293-11e9-9071-4d9b467200e9.gif" alt="alt text" width="300" height="whatever"></a>

## 2) Build dev env :

- [Download the exemple project from the website of play](https://www.playframework.com/getting-started)
- Insert/replace all the files inside the folder src/play in the exemple project folder

- Follow the instruction inside documentation to instal the database : [HOW_TO_Framwork_KUNDURA.md](./documentation/HOW_TO_Framwork_KUNDURA.md)

- Launch cassandra database
- go inside the folder of the exemple project downloaded beofre
- Launch : sbt run

the website is accesible by : [localhost:9000](http://localhost:9000)


## test of AKKA
```
scalac  -classpath "*jar:../lib/*" TestAkka.scala
scala  -classpath "*jar:../lib/*" TestAkka.scala
```


