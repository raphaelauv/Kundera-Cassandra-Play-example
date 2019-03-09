package model

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "time", schema = "KunderaExamples@cassandra_pu")
class TimePooca() {
  @Id
  var timeId:String=null

  @Column(name = "read")
  var startingDate: LocalDate = null

  @Column(name = "write")
  var endingDate: LocalDate = null

  def getTimeId() = timeId
  
  def getStartingDate() = startingDate 
  
}