package vehicle

import java.text.SimpleDateFormat
import java.util.*

abstract class Vehicle {
    companion object {
        fun createVehicle(vehicleType: VehicleType): Vehicle {
            return when (vehicleType) {
                VehicleType.CAR -> Car()
            }
        }
    }

    private val entryTime: Long = System.currentTimeMillis()
    private var exitTime: Long = -1

    fun setExitTime(exitTime: Long) {
        this.exitTime = exitTime
    }

    private fun getFormatTime(time: Long): String {
        return SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(Date(time))
    }

    fun getExitTime(): String {
        return getFormatTime(exitTime)
    }

    fun getEntryTime(): String {
        return getFormatTime(entryTime)
    }

    abstract fun parkVehicle()
    abstract fun unparkVehicle()

}