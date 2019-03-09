# Cassandra

## Remove existing version

```
sudo apt-get remove cassandra
```

## Install cassandra 2.1.15

```
echo "deb http://www.apache.org/dist/cassandra/debian 21x main" | sudo tee -a /etc/apt/sources.list.d/cassandra.sources.list

echo "deb-src http://www.apache.org/dist/cassandra/debian 21x main" | sudo tee -a /etc/apt/sources.list.d/cassandra.sources.list

echo "deb http://www.apache.org/dist/cassandra/debian 21x main" | sudo tee -a /etc/apt/sources.list.d/cassandra.list

sudo sh -c 'echo "deb http://debian.datastax.com/community/ stable main" >> /etc/apt/sources.list.d/datastax.list'

sudo apt-get install cassandra=2.1.15

sudo rm var/lib/cassandra/commitlog/*
```


## Setup Cassandra
```
sudo cassandra -f &

sudo nano etc/cassandra/cassandra-env.sh	

cassandra-cli

create keyspace Evaluator;
create keyspace KunderaExamples;

use Evaluator;

create column family users with comparator=UTF8Type and default_validation_class=UTF8Type and key_validation_class=UTF8Type;

create column family questions with comparator=UTF8Type and default_validation_class=UTF8Type and key_validation_class=UTF8Type;

create column family time with comparator=UTF8Type and default_validation_class=UTF8Type and key_validation_class=UTF8Type;

create column family pages with comparator=UTF8Type and default_validation_class=UTF8Type and key_validation_class=UTF8Type;

create column family informations with comparator=UTF8Type and default_validation_class=UTF8Type and key_validation_class=UTF8Type;

create column family files with comparator=UTF8Type and default_validation_class=UTF8Type and key_validation_class=UTF8Type;

create column family accespermission with comparator=UTF8Type and default_validation_class=UTF8Type and key_validation_class=UTF8Type;

```
