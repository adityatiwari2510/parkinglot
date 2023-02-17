package parkinglot

import vehicle.Vehicle
import vehicle.VehicleType

const val TOTAL_CAR_PARKING_SPOTS = 100
const val PARKING_SPOT_OCCUPIED = 1
const val PARKING_SPOT_FREE = 0

class EntryGate {
    companion object {
        var nextTicketNumber = 1L
    }

    val parkingSpot = ParkingSpot.getInstance()


    fun generateTicket(): Ticket {
        val car = Vehicle.createVehicle(VehicleType.CAR)
        val spotNumber = parkingSpot.allocateSpotForVehicle(car)
        return Ticket(nextTicketNumber++, spotNumber, car.getEntryTime())
    }
}