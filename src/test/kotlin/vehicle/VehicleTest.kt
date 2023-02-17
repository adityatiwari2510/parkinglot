package vehicle

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat


class VehicleTest {

    private fun isValidDate(dateStr: String, dateFormat: String): Boolean {
        val sdf: DateFormat = SimpleDateFormat(dateFormat)
        sdf.isLenient = false
        try {
            sdf.parse(dateStr)
        } catch (e: ParseException) {
            return false
        }
        return true
    }

    @Test
    fun `createVehicle should return the class of provided valid enum type`() {
        val vehicleType: VehicleType = VehicleType.CAR

        val response = Vehicle.createVehicle(vehicleType)

        assertTrue(response is Car)
    }

    @Test
    fun `getEntryTime should return time in correct format`() {
        val vehicleType: VehicleType = VehicleType.CAR
        val car = Vehicle.createVehicle(vehicleType)

        val response = car.getEntryTime()

        assertTrue(isValidDate(response, "dd-MMM-yyyy HH:mm:ss"))
    }

    @Test
    fun `getExitTime should return time in correct format`() {
        val vehicleType: VehicleType = VehicleType.CAR
        val car = Vehicle.createVehicle(vehicleType)
        car.setExitTime(System.currentTimeMillis())

        val response = car.getExitTime()

        assertTrue(isValidDate(response, "dd-MMM-yyyy HH:mm:ss"))
    }
}