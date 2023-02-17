package parkinglot

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import vehicle.Vehicle
import vehicle.VehicleType

class EntryGateTest {
    @Test
    fun `generateTicket should return Ticket`() {

        val response = EntryGate().generateTicket(Vehicle.createVehicle(VehicleType.CAR))

        assertEquals("", response)
    }
}