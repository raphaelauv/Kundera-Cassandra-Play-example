package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.List;
import java.util.ArrayList;

//import java.util.LinkedList;
//import scala.collection.mutable.ListBuffer  
class File{
  
}


@Embeddable
class ImageQuestion() extends FileQuestion[File,Int,Boolean](){
  
//   @Column(name = "anwser")
//   var anwser :Int = 0
//   
  override def evalAnwser(anwserGived:Int) :Boolean = {
    if(anwser.equals(anwserGived)){
      return true;
    }
    return false;
    
  }
}

@Embeddable
abstract class FileQuestion[F<:File,T,W]() extends Question[F,T,W](){
  
  override def evalAnwser(anwserGived:T) :W 
} 

@Embeddable
class SimpleQuestion() extends Question[String,Int,Int](){
  
//   @Column(name = "anwser")
//   override var anwser :Int = 0
  
  override def toString(): String = super.toString() + anwser
  
  override def evalAnwser(anwserGived:Int) :Int = {
    if(anwser.equals(anwserGived)){
      return 10;
    }
    return 0;
    
  }
}

// @Entity
// trait anwserEvaluable{
//   
//   @Id
//   var questionId:String=""
//   def setQuestionId(s:String){
//     questionId=s;
//   }
// }


@Embeddable
abstract class Question[K,T,W](){ 
  
  @Column(name = "title")
  var title:String = ""
  
  
  @ElementCollection
  @Column(name = "possibleAnwser")
  var possibleAnwser:List[K] = new java.util.ArrayList[K](); 
  
  @Column(name = "anwser")
  var anwser :T = null.asInstanceOf[T] //trick
  
  
  @Column(name = "isPossibleAnwser")
  var isPossibleAnwser: Boolean = false;
  
  
  def setTitle(_title:String) {
    title=_title  
  }
  
 
  def setAnwser(_anwser:T) {
    anwser = _anwser;
  }
  
 
  override def toString(): String = title +" >"
  
  def evalAnwser(anwserGived:T) : W 
  
}
