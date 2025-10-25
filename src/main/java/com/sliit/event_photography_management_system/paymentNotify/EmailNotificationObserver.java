package com.sliit.event_photography_management_system.paymentNotify;

import com.sliit.event_photography_management_system.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationObserver implements PaymentObserver {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void update(Payment payment) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(payment.getEmail());
            message.setSubject("Payment Status Update");
            message.setText("Hello " + payment.getName() + ",\n\n" +
                    "Your payment status has been updated to: " + payment.getStatus() + ".\n\n" +
                    "Thank you for using our event photography services!\n\n" +
                    "Best regards,\nEvent Photography Team");

            mailSender.send(message);

            System.out.println(" Email successfully sent to: " + payment.getEmail());
        } catch (Exception e) {
            System.err.println(" Failed to send email: " + e.getMessage());
        }
    }
}