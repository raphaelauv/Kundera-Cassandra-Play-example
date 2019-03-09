package controllers;

import model.NormalUser
import model.UserPooca
import model.AnonymeUser
import model.AdminUser

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.inject._
import play.api.mvc._


abstract class UserController[T <: UserPooca] @Inject() (cc: ControllerComponents, cl: Class[T]) extends DAOController[T](cc, cl) {

  namePersistUnit="cassandra_pu_user"
  
  def updateUser(id: Int): String = {
    "Rout not implemented";
  }

  def findUser(id: Int): T = {

    val rst = find(id);
    if (rst.isDefined) {
      
      if(rst.get.isInstanceOf[T]){ //TODO
        return rst.get;
        //"Found User in database with the following details:" + rst.get.toString();  
      }else{
        //"NOT GOOD TYPE";
        null.asInstanceOf[T]
      }
      
      
    } else {
      null.asInstanceOf[T]
      //"Record not finded";
    }

  }

  def deleteUser(id: Int): String = {
    val rst = delete(id);
    if (rst.isDefined) {
      "delete : " + rst.get.toString()
    } else {
      "Record not finded"
    }
  }

  def insertUser(user: T): String = {
    
    persistObject(user);
  }

}



class AdminUserController @Inject() (cc: ControllerComponents) extends UserController[AdminUser](cc, classOf[AdminUser]) {
  def insertAdmin() = Action {
    var user: AdminUser = new AdminUser();
    var id:Int = 40;
    Ok(views.html.mainmenu(insertUser(user)));
  }
    def updateAdmin(id: Int) = Action {
    Ok(views.html.mainmenu("Rout not implemented"))
  }

  def findAdmin(id: Int) = Action {
    
    val us = findUser(id);
   
    if(us==null) {
      Ok(views.html.index("not good"))
    } else if ( !us.isAdmin()){
        Ok(views.html.index("not admin"));    
    }else{
      Ok(views.html.mainmenu(us.toString()));
    }
    
    
  }

  def deleteAdmin(id: Int) = Action {
    Ok(views.html.mainmenu(deleteUser(id)))
  }  
  
}

class NormalUserController @Inject() (cc: ControllerComponents) extends UserController[NormalUser](cc, classOf[NormalUser]) {

  def insertNU(fname: String, lname: String) = Action {
    var user: NormalUser = new NormalUser()
    user.setFName(fname)
    user.setLastName(lname)
    user.setAdmin(false)
    Ok(views.html.mainmenu(insertUser(user)))
    
  }

  def updateNU(id: Int) = Action {
    Ok(views.html.mainmenu("Rout not implemented"))
  }

  def findNU(id: Int) = Action {
    val us = findUser(id);
    if(us==null){
      Ok(views.html.mainmenu("not good"))
    }else{
      Ok(views.html.mainmenu(us.toString()));  
    }
  }

  def deleteNU(id: Int) = Action {
    Ok(views.html.mainmenu(deleteUser(id)))
  }

}