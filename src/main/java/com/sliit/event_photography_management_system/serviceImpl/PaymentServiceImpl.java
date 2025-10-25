package com.sliit.event_photography_management_system.serviceImpl;

import com.sliit.event_photography_management_system.entity.Payment;
import com.sliit.event_photography_management_system.paymentNotify.EmailNotificationObserver;
import com.sliit.event_photography_management_system.paymentNotify.PaymentNotificationManager;
import com.sliit.event_photography_management_system.paymentStrategy.PaymentStrategyContext;
import com.sliit.event_photography_management_system.repository.PaymentRepository;
import com.sliit.event_photography_management_system.service.PaymentService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentNotificationManager paymentNotificationManager;

    @Autowired
    private EmailNotificationObserver emailNotificationObserver;

    @Autowired

    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentStrategyContext paymentStrategyContext;

    @PostConstruct
    public void init() {
        paymentNotificationManager.addObserver(emailNotificationObserver);

    }


    @Override
    public Payment createPayment(Payment payment) {
        paymentStrategyContext.getStrategy(payment.getMethod()).pay(payment);
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPayment(Long paymentid) {
        Optional<Payment> payment = paymentRepository.findById(paymentid);
        if (payment.isPresent()) {
            return payment.get();
        }
        else{
            throw new RuntimeException("Payment not found id"+paymentid);
        }
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment updatePayment(Long id, Payment payment) {
        Payment existingPayment = getPayment(id);
        existingPayment.setName(payment.getName());
        existingPayment.setEmail(payment.getEmail());
        existingPayment.setCardNumber(payment.getCardNumber());
        existingPayment.setExpiryDate(payment.getExpiryDate());
        existingPayment.setCvv(payment.getCvv());
        existingPayment.setPrice(payment.getPrice());
        existingPayment.setType(payment.getType());
        String oldStatus = existingPayment.getStatus();
        String newStatus = payment.getStatus();

        existingPayment.setStatus(newStatus);
        Payment updated = paymentRepository.save(existingPayment);

        // ✅ Safe comparison (no null crash)
        if ((oldStatus == null && newStatus != null) ||
                (oldStatus != null && !oldStatus.equals(newStatus))) {
            paymentNotificationManager.notifyObservers(updated);
        }

        return updated;
    }

    @Override
    public void deletePayment(Long paymentid) {
        Payment payment = getPayment(paymentid);
        paymentRepository.delete(payment);
    }

}
