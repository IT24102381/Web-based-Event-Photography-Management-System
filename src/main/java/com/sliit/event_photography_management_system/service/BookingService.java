package com.sliit.event_photography_management_system.service;
import com.sliit.event_photography_management_system.entity.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);
    Booking getBooking(Long id);
    List<Booking> getAllBookings();
    Booking updateBooking(Long id,Booking booking);
    void deleteBooking(Long id);
}
