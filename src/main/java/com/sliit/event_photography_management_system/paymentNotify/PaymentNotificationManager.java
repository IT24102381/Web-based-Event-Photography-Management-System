package com.sliit.event_photography_management_system.paymentNotify;

import com.sliit.event_photography_management_system.entity.Payment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentNotificationManager implements PaymentSubject {

    private final List<PaymentObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(PaymentObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(PaymentObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Payment payment) {
        for (PaymentObserver observer : observers) {
            observer.update(payment);
        }
    }
}