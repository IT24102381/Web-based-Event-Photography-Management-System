package com.sliit.event_photography_management_system.eventNotify;
import com.sliit.event_photography_management_system.entity.Booking;

public interface BookingObserver {
    void onBookingCreated(Booking booking);
}

