/**
  * Created by alertchanvit on 4/5/2017 AD.
  */
class CinemaAPI {
  //def buyTicket(film_name: String, seats_num: Int): Int  // return ticket_id
  //def confirmTicket(ticket_id: Int): boolean  // return true if the ticket has been confirmed.

  private var counter = 1
  private var tix_hashMap: Map[Int, Ticket] = Map()   // HashMap[ticket_id, Ticket]

  def buyTicket(film_name: String, seats_num: Int): Int = {
    val tix = new Ticket(counter, film_name, seats_num)
    tix_hashMap += (counter -> tix)
    counter += 1
    return tix.ticket_id
  }

  def confirmTicket(ticket_id: Int): Boolean = {
    var result = false

    if(this.tix_hashMap.contains(ticket_id)) {
      val confirmed_tix: Option[Ticket] = tix_hashMap.get(ticket_id)  // ize - but here, we have ensured that the ticket is really exist.
      confirmed_tix.get.confirmed = true
      result = true
    }
    else {
      result = false
    }

    return result
  }

}
