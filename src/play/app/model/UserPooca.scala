package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "users", schema = "Evaluator@cassandra_pu_user")
class AnonymeUser extends UserPooca() {
  
  override def toString(): String = {
    "ANONYME USER " + super.toString()
  }
}


@Entity
@Table(name = "users", schema = "Evaluator@cassandra_pu_user")
class NormalUser extends RegisteredUser() {
  setAdmin(false);
  
  
  override def toString(): String = {
    "NORMAL USER " + super.toString()
  }
}

@Entity
@Table(name = "users", schema = "Evaluator@cassandra_pu_user")
class AdminUser extends RegisteredUser() {
  setAdmin(true);
  
  override def toString(): String = {
    "ADMIN USER " + super.toString()
  }
}

@Entity
@Table(name = "users", schema = "Evaluator@cassandra_pu_user")
abstract class UserPooca() {
  
  @Id
  @TableGenerator(name = "gen", allocationSize = 1, initialValue = 1)
  @GeneratedValue(generator = "gen", strategy = GenerationType.TABLE)
  var userId:String=""

  @Column(name = "registrate")
  var registrate:Boolean=false

  def setUserId(s:String){
    userId=s;
  }
  
  def setRegistrate(b:Boolean){
    registrate=b
  }

  def getUserId() = userId
  
  override def toString(): String = {
    "\nuserId:" + this.getUserId();
  }

}



@Entity
@Table(name = "users", schema = "Evaluator@cassandra_pu_user")
abstract class RegisteredUser() extends UserPooca() {
  
  setRegistrate(true)
  
  @Column(name = "first_name")
  var fName:String=""
  
  @Column(name = "last_name")
  var lName:String=""
  
  @Column(name = "email")
  var email:String=""
  
  @Column(name = "admin")
  var admin:Boolean=false

  @Column(name = "password")
  var password:String=""
  
  def setFName(s:String){
    fName=s;
  }
  
  def setPW(s:String){
    password=s;
  } 

  def setAdmin(b:Boolean){
    admin=b    
  }
  
  def setLastName(s:String){
    lName=s;
  }
  
  def setEmail(s:String){
    email=s;
  }
  
  
  def getFirstName() = fName
  def getLastName() = lName
  def getEmail() = email
  def isAdmin() = admin
  def getPW() = password
  
  override def toString(): String = {
    super.toString()+" First Name:"+this.fName+" Last Name :"+lName +" isAdmin? : "+admin+" "
  }

}