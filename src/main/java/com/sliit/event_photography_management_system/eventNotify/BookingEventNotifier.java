package com.sliit.event_photography_management_system.eventNotify;

import com.sliit.event_photography_management_system.entity.Booking;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookingEventNotifier {

    private final List<BookingObserver> observers = new ArrayList<>();

    public void registerObserver(BookingObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(Booking booking) {
        for (BookingObserver observer : observers) {
            observer.onBookingCreated(booking);
        }
    }
}