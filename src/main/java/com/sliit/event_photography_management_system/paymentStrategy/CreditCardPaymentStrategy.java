package com.sliit.event_photography_management_system.paymentStrategy;


import com.sliit.event_photography_management_system.entity.Payment;
import org.springframework.stereotype.Component;

@Component("creditcard")
public class CreditCardPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(Payment payment) {
        System.out.println("Processing credit card payment for: " + payment.getName());

        // credit card logic
    }
}