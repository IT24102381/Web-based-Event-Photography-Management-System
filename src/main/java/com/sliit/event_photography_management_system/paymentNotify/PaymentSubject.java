package com.sliit.event_photography_management_system.paymentNotify;

import com.sliit.event_photography_management_system.entity.Payment;

public interface PaymentSubject {
    void addObserver(PaymentObserver observer);
    void removeObserver(PaymentObserver observer);
    void notifyObservers(Payment payment);
}