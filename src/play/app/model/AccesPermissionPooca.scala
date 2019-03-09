package model

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accespermission", schema = "KunderaExamples@cassandra_pu")
class AccesPermissionPooca() {
  @Id
  var permissionId:String=null

  @Column(name = "read")
  var read:Boolean=false

  @Column(name = "write")
  var write:Boolean=false

  def getPermId() = permissionId
  def getRead() = read
  def getWrite() = write
  
  def setPermId(s:String){
    permissionId=s;
  }
   
  def setRead(d:Boolean){
    read=d;
  }
  
  def setWrite(d:Boolean){
    write=d;
  }
  
}
