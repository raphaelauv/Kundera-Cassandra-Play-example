package controllers

object PageForm {
  import play.api.data.Forms._
  import play.api.data.Form

  
  case class PageData(title: String, permission: String)

  
  val form = Form(
    mapping(
      "title" -> nonEmptyText,
      "permission" -> nonEmptyText
    )(PageData.apply)(PageData.unapply)
  )
}
