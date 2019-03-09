package model

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "informations", schema = "KunderaExamples@cassandra_pu")
class InformationPooca() {
  @Id
  var userId:String=null

  @Column(name = "accespermissionId")
  var perms:AccesPermissionPooca=null

  @Column(name = "time")
  var time:TimePooca=null
  
  def getPers() = perms
  def getTime() = time
 

}