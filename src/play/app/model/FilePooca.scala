package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.TableGenerator;
import javax.persistence.Embedded;


@Entity
@Table(name = "files", schema = "Evaluator@cassandra_pu_file")
class Folder extends FilePooca() {
  
  //list de FilePooca
  
  override def toString(): String = {
    "Folder: " + super.toString()
  }
}

@Entity
@Table(name = "files", schema = "Evaluator@cassandra_pu_file")
class Simplefile extends FilePooca() {
    
}



@Entity
@Table(name = "files", schema = "Evaluator@cassandra_pu_file")
abstract class FilePooca() {
  
  @Id
  @TableGenerator(name = "id_gen", allocationSize = 30, initialValue = 100)
  @GeneratedValue(generator = "id_gen", strategy = GenerationType.TABLE)
  var fileId:String=""
    
  @Column(name = "path")
  var path:String=""
  
  
  @Column(name = "permission")
  var permission:String=""
  
  def setFileId(s:String){
    fileId=s;
  }
  
  def getfileId() = fileId
  
  def setPath(p : String) = {
    path = p
  }
  
  def getPath() = path
  
  def setPermission(p:String) = {
    permission = p
  }
  
  def getPermission() = permission
  
  override def toString(): String = {
    "filename => "+getPath() +", permission => "+getPermission() + "id => "+getfileId()
  }
  
}


