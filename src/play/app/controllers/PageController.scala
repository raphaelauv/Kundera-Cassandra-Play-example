package controllers;

import model.PagePooca
import model.SimpleContent
import model.Evaluation
import model.ExercicePooca
import model.QCM
import model.Exo

import PageForm._

import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.inject._
import play.api.data._
import play.api.i18n._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import scala.collection.JavaConverters._


abstract class PageController[T <: PagePooca] @Inject() (cc: ControllerComponents, cl: Class[T]) extends DAOController[T](cc, cl) {

  namePersistUnit="cassandra_pu_page"
  
  def updatePage(page:T): String = {
    if(update(page)){
        println("ok update")
        "ok update"
    }else{
        println("Erreur update")
        "Erreur update"
    }
  }

  def getPage(id: Int): Option[T] = {
    find(id);
  }

  def deletePage(id: Int): String = {
    val del = delete(id);
    if (del.isDefined) {
      "delete : " + del.get.toString()
    } else {
      "Record not finded"
    }
    
  }

  def insertPage(page: T): String = {
    persistObject(page)
  }

  
}

class SimpleContentController @Inject() (cc: ControllerComponents) extends PageController[SimpleContent](cc, classOf[SimpleContent]) {

  def insertSimpleContent(title: String, perm: String) = Action {
    if ((perm != "PUBLIC" && perm != "PRIVATE"
    && perm != "RESTRICTED")) {
      Ok(views.html.mainmenu("ERREUR"))
    } else {
      
      var sc: SimpleContent = new SimpleContent()
      sc.setTitle(title)
      sc.setPermission(perm)
      Ok(views.html.mainmenu(insertPage(sc)))
    }
  }
  
  def deleteSimpleContent(id: Int) = Action{
    Ok(views.html.mainmenu(deletePage(id)))
  }
  
  def getSimpleContent(id: Int) = Action{
    getPage(id) match{
        case Some(sc) => Ok(views.html.simpleContent(sc))
        case None => Ok(views.html.mainmenu("ERREUR"))
    }
  }
  
}

 class EvaluationController @Inject() (cc: ControllerComponents) extends PageController[Evaluation](cc, classOf[Evaluation]) with I18nSupport {
 
 private val postUrl = routes.HomeController.index

  def insertEvaluation(title: String, perm: String) = Action {
    if ((perm != "PUBLIC" && perm != "PRIVATE"
    && perm != "RESTRICTED")) {
      Ok(views.html.mainmenu("ERREUR"))
    } else {
      
      var sc: Evaluation = new Evaluation()
      sc.setTitle(title)
      sc.setPermission(perm)
      Ok(views.html.mainmenu(insertPage(sc)))
    }
  }
  
  def deleteEvalutation(id: Int) = Action{
    Ok(views.html.mainmenu(deletePage(id)))
  }
  
  def getEvaluation(id: Int) = Action{
    getPage(id) match{
        case Some(e) => 
           var n  = e.getExercices()
           val set = n.asScala.toSet
          Ok(views.html.evaluation(e,set))
        case None => Ok(views.html.mainmenu("This page does not exist."))
    }
  }
  
  def addExercice(id_page:Int) = Action{
    println("addExercice entree:")
    getPage(id_page) match{
        case Some(e) => 
            var l: List[QCM] = new ArrayList()
             e.addExercice(new QCM)
           updatePage(e)
           val set = e.getExercices().asScala.toSet
          Ok(views.html.evaluation(e,set))
        case None => Ok(views.html.mainmenu("This page does not exist."))
    }
  }
  
  def findAllPage() = Action{
    var l= findAll("SELECT p from Evaluation p")
    val set = l.asScala.toSet
    Ok(views.html.pages(set))
  }
  def addPage() = Action{implicit request:Request[AnyContent] =>
    Ok(views.html.addPage(form))
  
  }
  
 def createPage() = Action { implicit request:Request[AnyContent] =>
    val errorFunction = { formWithErrors: Form[PageData] =>
      BadRequest(views.html.addPage(formWithErrors))
    }

    val successFunction = { data: PageData =>
      var sc: Evaluation = new Evaluation()
      sc.setTitle(data.title)
      sc.setPermission(data.permission)
      insertPage(sc)
      Ok(views.html.mainmenu(insertPage(sc)))
    }

    val formValidationResult = form.bindFromRequest
    formValidationResult.fold(errorFunction, successFunction)
  }
  


}
 
