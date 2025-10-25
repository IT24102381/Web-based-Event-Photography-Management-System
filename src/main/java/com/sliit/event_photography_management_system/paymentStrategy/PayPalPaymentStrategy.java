package com.sliit.event_photography_management_system.paymentStrategy;

import com.sliit.event_photography_management_system.entity.Payment;
import org.springframework.stereotype.Component;

@Component("paypal")
public class PayPalPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(Payment payment) {
        System.out.println("Processing PayPal payment for: " + payment.getName());

        // PayPal logic

    }
}