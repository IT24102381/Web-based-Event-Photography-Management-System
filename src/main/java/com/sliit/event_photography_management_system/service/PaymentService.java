package com.sliit.event_photography_management_system.service;

import com.sliit.event_photography_management_system.entity.Payment;

import java.util.List;


public interface PaymentService {
    Payment createPayment(Payment payment);
    Payment getPayment(Long paymentid);
    List<Payment> getAllPayments();
    Payment updatePayment(Long paymentid,Payment payment);
    void deletePayment(Long paymentid);


}
