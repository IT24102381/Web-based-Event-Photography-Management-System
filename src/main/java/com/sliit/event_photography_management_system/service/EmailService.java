package com.sliit.event_photography_management_system.service;

public interface EmailService {
    void sendBookingEmail(String toEmail, String subject, String body);
}
