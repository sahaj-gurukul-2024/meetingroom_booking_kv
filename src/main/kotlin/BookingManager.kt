package org.example

import org.example.entities.Booking
import org.example.entities.MeetingRoom
import org.example.entities.TimeRange

class BookingManager(private var meetingRooms: List<MeetingRoom> = listOf())
{
    fun checkAvailability(timeRange: TimeRange): List<MeetingRoom> {
        return meetingRooms.filter { room ->
            room.bookings.none {booking ->
                timeRange.startTime < booking.timeRange.endTime &&
                        timeRange.endTime > booking.timeRange.startTime
            }
        }
    }

    fun bookRoom(booker: String, agenda: String, timeRange: TimeRange): Boolean {
        val availableRooms =  checkAvailability(timeRange)
        if (availableRooms.isNotEmpty()) {
            availableRooms.firstOrNull()!!.bookings.addLast(Booking(booker, agenda, timeRange))
            return true
        }
        return false
    }




}