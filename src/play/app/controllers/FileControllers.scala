package controllers;

import model.FilePooca
import model.Folder
import model.Simplefile

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.inject._
import play.api.mvc._


abstract class FileController[T <: FilePooca] @Inject() (cc: ControllerComponents, cl: Class[T]) extends DAOController[T](cc, cl) {

  namePersistUnit="cassandra_pu_file"
  
  def updateFile(f: T): String = {
    if(update(f))
        "ok"
    else
        "erreur"
  }

  def getFile(id: Int): Option[T] = {
    find(id);
  }

  def deleteFile(id: Int): String = {
    val del = delete(id);
    if (del.isDefined) {
      "delete : " + del.get.toString()
    } else {
      "Record not finded"
    }
    
  }

  def insertFile(file: T): String = {
//     file.setFileId("" + id)
    persistObject(file)
  }

  
}

class FolderController @Inject() (cc: ControllerComponents) extends FileController[Folder](cc, classOf[Folder]) {

  def insertFolder(path: String, perm: String) = Action {
    if ((perm != "PUBLIC" && perm != "PRIVATE"
    && perm != "RESTRICTED")) {
      Ok(views.html.mainmenu("ERREUR"))
    } else {
      var f: Folder = new Folder()
      f.setPath(path)
      f.setPermission(perm)
      Ok(views.html.mainmenu(insertFile(f)))
    }
  }
  
  def deleteFolder(id: Int) = Action{
    Ok(views.html.mainmenu(deleteFile(id)))
  }
  
  def getFolder(id: Int) = Action{
    getFile(id) match{
        case Some(sc) => Ok(views.html.folder(sc))
        case None => Ok(views.html.mainmenu("Erreur"))
    }
  }
  
}