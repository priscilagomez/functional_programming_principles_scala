package chapter_4
import java.util.Date

import java.util.Date


/*
* TRAILS: son plantillas para crear clases
* CASE CLASS: es una abreviatura para definir una clase, un objecto... Son ideales para crear clases ligera
* */
trait Visitor {
  def id: String      // Unique id assigned to each user
  def createdAt: Date // Date this user first visited the site

  // How long has this visitor been around?
  def age: Long = new Date().getTime - createdAt.getTime

  def older(v1: Visitor, v2: Visitor): Boolean =
    v1.createdAt.before(v2.createdAt)
}

// Es un subtipo del trail Visitor
case class Anonymous(
                      id: String,
                      createdAt: Date = new Date()
                    ) extends Visitor
// Es un subtipo del trail Visitor
case class User(
                 id: String,
                 email: String,
                 createdAt: Date = new Date()
               ) extends Visitor
