package com.sliit.event_photography_management_system.eventNotify;

import com.sliit.event_photography_management_system.entity.Booking;
import com.sliit.event_photography_management_system.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoordinatorEmailObserver implements BookingObserver {

    @Autowired
    private EmailService emailService;

    private final String coordinatorEmail = "yuthikaofficial@gmail.com";

    @Override
    public void onBookingCreated(Booking booking) {
        String subject = "New Event Booking Received";
        String body = String.format("""
                Hello Coordinator,

                A new event has been booked.

                 Client: %s
                 Email: %s
                 Event: %s
                 Date: %s
                 Time: %s
                 Location: %s
                 Photographer: %s
                 Package: %s

                Please take necessary arrangements.
                """,
                booking.getName(),
                booking.getEmail(),
                booking.getEventType(),
                booking.getDate(),
                booking.getTime(),
                booking.getLocation(),
                booking.getPhotographer(),
                booking.getPackageType()
        );

        emailService.sendBookingEmail(coordinatorEmail, subject, body);
    }
}
