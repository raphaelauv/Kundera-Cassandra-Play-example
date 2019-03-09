package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Enumerated;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.TableGenerator;
import javax.persistence.ElementCollection;
import javax.persistence.CollectionTable;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import scala.collection.JavaConverters._

@Entity
@Table(name = "pages", schema = "Evaluator@cassandra_pu_page")
class SimpleContent extends PagePooca() {
  
  override def toString(): String = {
    "SimpleContent: " + super.toString()
  }
}



@Entity
@Table(name = "pages", schema = "Evaluator@cassandra_pu_page")
class Evaluation extends PagePooca(){

  @Column(name="exercices_list")
  var exercices: List[QCM] = new ArrayList[QCM]()
  def setExercices(e:List[QCM]) = {
    exercices = e
  }
  def getExercices() = exercices
  
  def addExercice(e:QCM) = {
   exercices.add(e)
  }
     
  override def toString(): String = {
    "Evaluation: " + super.toString()
  }
}

@Entity
@Table(name = "pages", schema = "Evaluator@cassandra_pu_page")
abstract class PagePooca() {
  
  @Id
  @TableGenerator(name = "gen", allocationSize = 30, initialValue = 100)
  @GeneratedValue(generator = "gen", strategy = GenerationType.TABLE)
  var pageId:String=""
  
  @Column(name = "title")
  var title:String=""
  
  @Column(name = "permission")
  var permission:String=""
  
  @Column(name= "idFolder")
  var idFolder : String = ""

  def setIdFolder(st:String) = {
    idFolder = st
  }
  def getIdFolder() = idFolder

  def setTitle(s:String){
    title=s;
  }
  
  def getTitle() = title

  def setPermission(p:String) = {
    permission = p
  }
  
  def getPermission() = permission
  
  def setPageId(s:String){
    pageId=s;
  }
  
  def getPageId() = pageId
  
  
  override def toString(): String = {
    "Title => "+getTitle() +", permission => "+getPermission()+" id =>"+getPageId()
  }
  
}



