# Download the compressed file containing the example

- [example.tar.gz](example.tar.gz)

# Setup Cassandra Databse


## 1) Install cassandra 2.1.15

## 2) Run cassandra

```
sudo cassandra -f &
```

### 3) edit cassandra-env.sh

```
sudo nano etc/cassandra/cassandra-env.sh
```

### 4) create tables

```	
cassandra-cli

create keyspace Evaluator;

use Evaluator;

create column family users with comparator=UTF8Type and default_validation_class=UTF8Type and key_validation_class=UTF8Type;

create column family questions with comparator=UTF8Type and default_validation_class=UTF8Type and key_validation_class=UTF8Type;

create column family time with comparator=UTF8Type and default_validation_class=UTF8Type and key_validation_class=UTF8Type;

create column family pages with comparator=UTF8Type and default_validation_class=UTF8Type and key_validation_class=UTF8Type;

create column family informations with comparator=UTF8Type and default_validation_class=UTF8Type and key_validation_class=UTF8Type;

create column family files with comparator=UTF8Type and default_validation_class=UTF8Type and key_validation_class=UTF8Type;

create column family accespermission with comparator=UTF8Type and default_validation_class=UTF8Type and key_validation_class=UTF8Type;
```


# Running example

cd play-scala-starter-example
Run this using [sbt](http://www.scala-sbt.org/).  If you downloaded this project from http://www.playframework.com/download then you'll find a prepackaged version of sbt in the project directory:

```
sbt run
```

And then go to http://localhost:9000 to see the running web application.
