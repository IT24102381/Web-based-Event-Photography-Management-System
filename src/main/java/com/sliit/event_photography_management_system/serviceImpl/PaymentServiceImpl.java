package com.sliit.event_photography_management_system.serviceImpl;

import com.sliit.event_photography_management_system.entity.Payment;
import com.sliit.event_photography_management_system.repository.PaymentRepository;
import com.sliit.event_photography_management_system.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired

    private PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
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
        return paymentRepository.save(existingPayment);
    }

    @Override
    public void deletePayment(Long paymentid) {
        Payment payment = getPayment(paymentid);
        paymentRepository.delete(payment);
    }

}
