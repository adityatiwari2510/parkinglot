package parkinglot


class Ticket(private val tickerNumber: Long, private val spotNumber: Number, private val entryTime: String) {
    override fun toString(): String {
        return "Parking Ticket:\n" +
                " Ticket Number: $tickerNumber \n" +
                " Spot Number: $spotNumber \n" +
                " Entry Date-time: $entryTime "
    }
}