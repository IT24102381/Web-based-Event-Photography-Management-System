package com.sliit.event_photography_management_system.ticketNotify;

import com.sliit.event_photography_management_system.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class TicketCreaterEmailObserver implements TicketObserver {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void update(Ticket ticket, String eventType) {
        String recipient = ticket.getTemail(); // ticket creator email
        String subject;
        String message;

        if (eventType.equalsIgnoreCase("CREATED")) {
            subject = "Ticket Created Successfully - " + ticket.getTsubject();
            message = "Hello " + ticket.getTname() + ",\n\n"
                    + "Your support ticket has been created successfully.\n"
                    + "Ticket ID: " + ticket.getTid() + "\n"
                    + "Status: " + ticket.getTstatus() + "\n\n"
                    + "Our team will contact you shortly.\n\nThank you,\nSupport Team";

        } else if (eventType.equalsIgnoreCase("UPDATED")) {
            subject = "Ticket Status Updated - " + ticket.getTsubject();
            message = "Hello " + ticket.getTname() + ",\n\n"
                    + "Your ticket status has been updated to: " + ticket.getTstatus() + "\n\n"
                    + "Thank you for your patience.\n\nSupport Team";

        } else {
            return;
        }

        sendEmail(recipient, subject, message);
    }

    private void sendEmail(String to, String subject, String text) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(text);
        mailSender.send(mail);
    }
}
