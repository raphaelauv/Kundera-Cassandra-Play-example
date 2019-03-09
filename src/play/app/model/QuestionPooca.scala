// package model;
// 
// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.Id;
// import javax.persistence.Table;
// import javax.persistence.Enumerated;
// import javax.persistence.Embedded;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.TableGenerator;
// import javax.persistence.Embedded;
// 
// @Embeddable
// abstract class Question[K,T,W](_title:String,_anwser:T) extends anwserEvaluable{ 
//   var title:String = _title
//   var possibleAnwser : List[K] = Nil;
//   var isPossibleAnwser: Boolean = false;
//   var anwser :T = _anwser
//  
//   override def toString(): String = title +" >"+ anwser
//   
//   def evalAnwser(anwserGived:T) : W 
//   
// }