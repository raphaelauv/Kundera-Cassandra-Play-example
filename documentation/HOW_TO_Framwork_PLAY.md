# PLAY FRAMWORK

## 1) Install SBT

http://www.scala-sbt.org/download.html
```
echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823
sudo apt-get update
sudo apt-get install sbt
```

## 2) Instal PLAY

- [Download example project](https://www.playframework.com/download)

- unzip the file
```
cd  play-scala-starter-example/

sbt run
```
