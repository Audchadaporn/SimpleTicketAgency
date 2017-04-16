/**
  * Created by alertchanvit on 4/5/2017 AD.
  */

import scala.io.StdIn
object TicketAgency {
  def main(args: Array[String]): Unit = {

    var ticket_count = 0
    val sf_offset = 0
    val major_offset = 100
    val paragon_offset = 200

    while(true) {
      println(s"Welcome to CHA MOVIE TICKET AGENCY \n Press 1 to buy a ticket. \n Press 2 to confirm a ticket")
      var ext_api: CinemaAPI = null
      val input = StdIn.readInt()
      if(input == 1) {  // buy a ticket
        println(s"Please choose cinema: \n 1. SF Cinema \n 2. Major Cineplex \n 3. Paragon Cineplex")
        val cinema_id = StdIn.readInt()
        println("Please enter the film name: ")
        val film_name = StdIn.readLine()
        println("PLease enter the number of seats: ")
        val seats_num = StdIn.readInt()

        var cinema_name: String = ""
        cinema_id match {
          case 1 => {
            ext_api = new SFAPI()
            cinema_name = "SF Cinema"
          }
          case 2 => {
            ext_api = new MajorAPI()
            cinema_name = "Major Cineplex"
          }
          case 3 => {
            ext_api = new ParagonAPI()
            cinema_name = "Paragon Cineplex"
          }
        }
        var ticket_id = ext_api.buyTicket(film_name, seats_num)

        // store the number of tickets sold by the agency
        cinema_id match {
          case 1 => ticket_id += sf_offset
          case 2 => ticket_id += major_offset
          case 3 => ticket_id += paragon_offset
        }
        ticket_count += 1
        println(s"$seats_num seats for the film $film_name at $cinema_name, your ticket number is $ticket_id")
        println("BYE")  // fix the flow later
      }
      else {
        // confirm a ticket
        println("Please enter ticket number: ")
        var ticket_id = StdIn.readInt()
        var tmp_ticket_id = ticket_id
        var ext_api: CinemaAPI = null

        if(ticket_id < 100) {
          tmp_ticket_id -= sf_offset
          ext_api = new SFAPI()
        }
        else if(ticket_id > 100 && ticket_id < 200) {
          tmp_ticket_id -= major_offset
          ext_api = new MajorAPI()
        }
        else {
          tmp_ticket_id -= paragon_offset
          ext_api = new ParagonAPI()
        }

        if(ext_api.confirmTicket(tmp_ticket_id) == true) {
          println(s"The ticket number $ticket_id has been confirmed.")
        }
        else {
          println(s"Cannot find the ticket number: $ticket_id")
          println("BYE")  // fix the flow later
        }

      }
    }

  }
}
