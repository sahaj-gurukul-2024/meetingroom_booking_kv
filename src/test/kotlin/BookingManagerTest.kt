import org.example.BookingManager
import org.example.entities.Booking
import org.example.entities.MeetingRoom
import org.example.entities.TimeRange
import org.junit.jupiter.api.Test
import java.sql.Time
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.test.assertEquals

class BookingManagerTest{
    @Test
    fun `ensure there is one available room for non-colliding time ranges`() {
        val startTime = LocalDateTime.of(2024, 3, 7, 12, 0)
        val endTime = LocalDateTime.of(2024, 3, 7, 14, 0)
        val timeRange = TimeRange(startTime, endTime)
        val booking = Booking("Keshav", "Pune hikes", timeRange)
        val meetingRoom = MeetingRoom(1, 1, listOf(booking))

        val bookingManager = BookingManager(mutableListOf(meetingRoom))
        val checkForStartTime = LocalDateTime.of(2024, 3, 7, 14, 0)
        val checkForEndTime = LocalDateTime.of(2024, 3, 7, 17, 0)
        val checkTimeRange = TimeRange(checkForStartTime, checkForEndTime)
        val result = bookingManager.checkAvailability(checkTimeRange)

        assertEquals(mutableListOf(meetingRoom), result)
    }

    @Test
    fun `ensure there are no available rooms for non-colliding time ranges`() {
        val startTime = LocalDateTime.of(2024, 3, 7, 12, 0)
        val endTime = LocalDateTime.of(2024, 3, 7, 14, 0)
        val timeRange = TimeRange(startTime, endTime)
        val booking = Booking("Keshav", "Pune hikes", timeRange)
        val meetingRoom = MeetingRoom(1, 1, listOf(booking))

        val bookingManager = BookingManager(mutableListOf(meetingRoom))
        val checkForStartTime = LocalDateTime.of(2024, 3, 7, 11, 0)
        val checkForEndTime = LocalDateTime.of(2024, 3, 7, 14, 0)
        val checkTimeRange = TimeRange(checkForStartTime, checkForEndTime)
        val result = bookingManager.checkAvailability(checkTimeRange)

        assertEquals(mutableListOf(), result)
    }

    @Test
    fun `book room for a given time range on a given day`() {
        val startTime1 = LocalDateTime.of(2024, 3, 7, 12, 0)
        val endTime1 = LocalDateTime.of(2024, 3, 7, 14, 0)
        val timeRange1 = TimeRange(startTime1, endTime1)
        val booking1 = Booking("Keshav", "Pune hikes", timeRange1)

        val startTime2 = LocalDateTime.of(2024, 3, 7, 16, 0)
        val endTime2 = LocalDateTime.of(2024, 3, 7, 17, 0)
        val timeRange2 = TimeRange(startTime2, endTime2)
        val booking2 = Booking("vikhyat", "random", timeRange2)

        val meetingRoom = MeetingRoom(1, 1, listOf(booking1,booking2))

        val bookingManager = BookingManager(mutableListOf(meetingRoom))









    }
}