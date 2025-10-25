package com.sliit.event_photography_management_system.paymentStrategy;


import com.sliit.event_photography_management_system.entity.Payment;

public interface PaymentStrategy {
    void pay(Payment payment);
}
