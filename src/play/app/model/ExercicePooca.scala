package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Enumerated;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.TableGenerator;
import javax.persistence.ElementCollection;
import java.util.List;
import java.util.ArrayList;

@Embeddable
class QCM extends ExercicePooca(){
  @ElementCollection
  @Column(name="questions_list")
  var questions: List[SimpleQuestion] = new ArrayList[SimpleQuestion](new ArrayList[SimpleQuestion]())
  
  def setQuestions(e:List[SimpleQuestion]) = {
    questions = e
  }
  def getQuestions() = questions
     
  override def toString(): String = {
    "QCM: " + super.toString()
  }
}
@Embeddable
class Exo extends ExercicePooca(){}

@Embeddable
abstract class ExercicePooca() {
  
//   @Id
//   @TableGenerator(name = "id_gen", allocationSize = 1, initialValue = 1)
//   @GeneratedValue(generator = "id_gen", strategy = GenerationType.TABLE)
  
  @Column(name = "title")
  var title:String=""
  
  @Column(name= "exerciceId")
  var exerciceId : String = ""

  def setExercieId(st:String) = {
    exerciceId = st
  }
  def getExercieId() = exerciceId

  def setTitle(s:String){
    title=s;
  }
  
  def getTitle() = title

  
  override def toString(): String = {
    "Title => "+getTitle() +", id => "+getExercieId()
  }
  
}