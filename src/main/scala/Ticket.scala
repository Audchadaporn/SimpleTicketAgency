/**
  * Created by alertchanvit on 4/5/2017 AD.
  * A user buys one ticket but one ticket may have many seats.
  */
class Ticket(ticketId: Int, filmName: String, seatsNum: Int) {
  var ticket_id: Int = ticketId
  var film_name: String = filmName
  var seats_num: Int = seatsNum
  var confirmed: Boolean = false
}
