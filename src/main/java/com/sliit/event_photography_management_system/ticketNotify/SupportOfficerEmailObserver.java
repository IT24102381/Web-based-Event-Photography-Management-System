package com.sliit.event_photography_management_system.ticketNotify;


import com.sliit.event_photography_management_system.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SupportOfficerEmailObserver implements TicketObserver {

    @Autowired
    private JavaMailSender mailSender;


    private static final String SUPPORT_EMAIL = "yuthikaofficial@gmail.com";

    @Override
    public void update(Ticket ticket, String eventType) {
        if (eventType.equalsIgnoreCase("CREATED")) {
            String subject = " New Ticket Created - " + ticket.getTsubject();
            String message = "A new ticket has been created by: " + ticket.getTname() + "\n\n"
                    + "Ticket ID: " + ticket.getTid() + "\n"
                    + "Subject: " + ticket.getTsubject() + "\n"
                    + "Message: " + ticket.getTmessage() + "\n\n"
                    + "Please review and assign this ticket.\n\nSupport System";

            sendEmail(SUPPORT_EMAIL, subject, message);
        }
    }

    private void sendEmail(String to, String subject, String text) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(text);
        mailSender.send(mail);
    }
}

