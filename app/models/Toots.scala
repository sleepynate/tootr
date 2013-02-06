package models

import java.util.Date

case class Toot (id:      Long,
                  message: String,
                  posted:  Date) {

}

object Toot {

  var toots = List.empty[Toot]

  def add(s: String) = {
    val date = new Date()
    val t = Toot(0, s, date)
    toots = toots :+ t
  }


  def all() = toots
}
