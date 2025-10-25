package com.sliit.event_photography_management_system.eventNotify;

import com.sliit.event_photography_management_system.entity.Booking;
import com.sliit.event_photography_management_system.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerEmailObserver implements BookingObserver {

    @Autowired
    private EmailService emailService;

    @Override
    public void onBookingCreated(Booking booking) {
        String subject = " Your Event Booking Confirmation";
        String body = String.format("""
                Hi %s,

                Your event has been successfully booked!

                 Event: %s
                 Date: %s
                 Time: %s
                 Location: %s
                 Photographer: %s
                 Package: %s

                Thank you for choosing us!
                """,
                booking.getName(),
                booking.getEventType(),
                booking.getDate(),
                booking.getTime(),
                booking.getLocation(),
                booking.getPhotographer(),
                booking.getPackageType()
        );

        emailService.sendBookingEmail(booking.getEmail(), subject, body);
    }
}
