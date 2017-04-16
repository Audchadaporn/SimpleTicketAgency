import org.scalatest.FunSuite

/**
  * Created by alertchanvit on 4/5/2017 AD.
  */
class CinemaAPITest extends FunSuite {
  test("buyTicket method works correctly") {
    val cinAPI = new CinemaAPI
    assert(cinAPI.buyTicket("Star Wars", 2) == 1)
  }
}
