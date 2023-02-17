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

    private val carParkingSpots = Array<Int>(TOTAL_CAR_PARKING_SPOTS) { PARKING_SPOT_FREE }

    private fun isCarParkingSpotFree(): Boolean {
        return carParkingSpots.contains(PARKING_SPOT_FREE)
    }

    fun generateTicket(): Ticket {
        val car = Vehicle.createVehicle(VehicleType.CAR)

        if (isCarParkingSpotFree()) {
            val spotNumber = car.parkVehicle()
            return Ticket(nextTicketNumber++, 1, car.getEntryTime())
        }

        throw Exception("Parking Slots not available.")
    }
}