package controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;
import javax.inject._
import play.api.mvc._

object BDController {

}

abstract class BDController[T] @Inject() (cc: ControllerComponents, cl: Class[T]) extends AbstractController(cc) {

  var typeClass: Class[T] = cl
  var namePersistUnit:String =""
  var emf: EntityManagerFactory = null
  var emfErreur = false
  

  def getEmf: EntityManagerFactory = {
    if (emf == null || !emf.isOpen() || emfErreur) {
      println("in getEmf : "+namePersistUnit);
      emf = Persistence.createEntityManagerFactory(namePersistUnit);
      emfErreur = false
      println(emf);
    }
    emf

  }

  def persistObject(t: T): String = {
    if (persist(t)) {
      "Record added:" + t.toString();
    } else {
      "BD not ready";
    }
  }

  def persist(t: T): Boolean = {

    try {
      println("try to persist : "+t)
      var em: EntityManager = getEmf.createEntityManager();
      
      
      
      em.persist(t);
      em.close();
      true
    } catch {
      case e: Exception => {
      	println ("\n" + e)
    	println ("\n" + e.getStackTrace + "\n")
        emfErreur = true
        false
      }
    }
  }

  def find(id: Int): Option[T] = {

    try {
      var em: EntityManager = getEmf.createEntityManager();

      var t: T = em.find(typeClass, "" + id);
      em.close();
      if (t != null) {
        //Ok(views.html.index("Found User in database with the following details:" + T.toString()));
        Some(t)

      } else {
        //Ok(views.html.index("Record not finded"));
        None

      }
    } catch {
      case e: Exception => {
        emfErreur = true
        None
        //Ok(views.html.index("BD not ready"))

      }
    }

  }
  
  def findAll(q:String ) = {

    try {
        var em: EntityManager = getEmf.createEntityManager()
        var query: Query = em.createQuery(q);
        var list = query.getResultList().asInstanceOf[List[T]];     
        em.close()
        list
    } catch {
      case e: Exception => {
        emfErreur = true
        new ArrayList()

      }
    }

  }

  def update(t: T): Boolean = {
    try {
      var em: EntityManager = getEmf.createEntityManager()

      //var t: T = em.find(typeClass, "0001");
      //user.setCity("New York");
      em.merge(t)
      //user = em.find(typeClass, "0001");
      //Ok(views.html.index("Record updated:" + user.toString()));
      true;
    } catch {
      case e: Exception => {
        emfErreur = true
        //Ok(views.html.index("BD not ready"))
        false
      }
    }

  }

  def delete(id: Int): Option[T] = {

    if (id == -1) {
      None
    } else {

      try {
        var em: EntityManager = getEmf.createEntityManager();

        var t: T = em.find(typeClass, "" + id);
        if (t != null) {
          em.remove(t);
          Some(t)
        } else {
          None
        }
      } catch {
        case e: Exception => {
          emfErreur = true
          None
        }
      }

    }

  }

}

abstract class DAOController[T] @Inject() (cc: ControllerComponents, cl: Class[T]) extends BDController[T](cc, cl) {

}
