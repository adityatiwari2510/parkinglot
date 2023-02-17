package parkinglot

import vehicle.Vehicle

class ParkingSpot private constructor() {
    companion object {
        private lateinit var parkingSpot: ParkingSpot
        fun getInstance(): ParkingSpot {
            if (!::parkingSpot.isInitialized) {
                parkingSpot = ParkingSpot()
            }
            return parkingSpot
        }
    }

    private val carParkingSpots = Array<Int>(TOTAL_CAR_PARKING_SPOTS) { PARKING_SPOT_FREE }

    private val vehicleParkingSpotMapping = mutableMapOf<Int, Vehicle>()

    private fun isCarParkingSpotFree(): Boolean {
        return carParkingSpots.contains(PARKING_SPOT_FREE)
    }

    fun allocateSpotForVehicle(vehicle: Vehicle): Int {
        if (isCarParkingSpotFree()) {
            for (spot in carParkingSpots) {
                if (spot != PARKING_SPOT_OCCUPIED) {
                    vehicleParkingSpotMapping[spot] = vehicle
                    return spot
                }
            }
        }
        throw Exception("Parking spot not available.")
    }
}