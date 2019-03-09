// package controllers;
// 
// import javax.persistence.EntityManager;
// import javax.persistence.EntityManagerFactory;
// import javax.persistence.Persistence;
// import javax.inject._
// import play.api.mvc._
// 
// 
// import model.Question
// import model.anwserEvaluable
// import model.ImageQuestion
// import model.SimpleQuestion
// 
// 
// abstract class QuestionController[T <: anwserEvaluable] @Inject() (cc: ControllerComponents, cl: Class[T]) extends DAOController[T](cc, cl) {
// 
//   
//   namePersistUnit="questionsPU"
//   
//   
//   def updateQuestion(id: Int): String = {
//     "Rout not implemented";
//   }
// 
//   def findQuestion(id: Int): T = {
// 
//     val rst = find(id);
//     if (rst.isDefined) {
//       
//       if(rst.get.isInstanceOf[T]){ //TODO
//         return rst.get;
//         //"Found User in database with the following details:" + rst.get.toString();  
//       }else{
//         //"NOT GOOD TYPE";
//         null.asInstanceOf[T]
//       }
//       
//       
//     } else {
//       null.asInstanceOf[T]
//       //"Record not finded";
//     }
// 
//   }
// 
//   def deleteQuestion(id: Int): String = {
//     val rst = delete(id);
//     if (rst.isDefined) {
//       "delete : " + rst.get.toString();
//     } else {
//       "Record not finded";
//     }
//   }
// 
//   def insertQuestion(question: T, id: Int): String = {
//     
//     question.setQuestionId(""+id);
//     persistObject(question);
//   }
// 
// }
// 
// 
// 
// class ImageQuestionController @Inject() (cc: ControllerComponents) extends QuestionController[ImageQuestion](cc, classOf[ImageQuestion]) {
//   def insertImageQuestion() = Action {
//     
//     val imgQ:ImageQuestion = new ImageQuestion();
//     var id:Int = 40;
//     Ok(views.html.index(insertQuestion(imgQ, id)));
//   }
//     def updateAdmin(id: Int) = Action {
//     Ok(views.html.index("Rout not implemented"))
//   }
// 
//   def findImageQuestion(id: Int) = Action {
//     
//     val us = findQuestion(id);
//    
//     if(us==null) {
//       Ok(views.html.index("not good"))
//     }else{
//       Ok(views.html.index(us.toString()));
//     }
//     
//     
//   }
// 
//   def deleteImageQuestion(id: Int) = Action {
//     Ok(views.html.index(deleteQuestion(id)))
//   }  
//   
// }
// 
// class SimpleQuestionController @Inject() (cc: ControllerComponents) extends QuestionController[SimpleQuestion](cc, classOf[SimpleQuestion]) {
// 
//   def insertSimpleQuestion(id: Int, question: String, anwser: Int) = Action {
//     if (id == -1) {
//       Ok(views.html.index("ERREUR REST API"));
//     } else {
//       
//        val sQ:SimpleQuestion = new SimpleQuestion();
//        
//        sQ.setTitle(question)
//        
//        sQ.anwser = anwser;
//        //sQ.setAnwser(anwser);
//        
//        println("la question : "+sQ);
//        
//       Ok(views.html.index(insertQuestion(sQ, id)));
//     }
//   }
// 
//   def updateSimpleQuestion(id: Int) = Action {
//     Ok(views.html.index("Rout not implemented"))
//   }
// 
//   def findSimpleQuestion(id: Int) = Action {
//     val us = findQuestion(id);
//     if(us==null){
//       Ok(views.html.index("not good"))
//     }else{
//       Ok(views.html.index(us.toString()));  
//     }
//   }
// 
//   def deleteSimpleQuestion(id: Int) = Action {
//     Ok(views.html.index(deleteQuestion(id)))
//   }
// 
// }