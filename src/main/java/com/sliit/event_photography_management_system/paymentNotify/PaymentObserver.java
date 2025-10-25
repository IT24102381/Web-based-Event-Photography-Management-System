package com.sliit.event_photography_management_system.paymentNotify;


import com.sliit.event_photography_management_system.entity.Payment;

public interface PaymentObserver {
    void update(Payment payment);
}