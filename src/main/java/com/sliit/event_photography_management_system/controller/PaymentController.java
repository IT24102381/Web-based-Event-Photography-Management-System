package com.sliit.event_photography_management_system.controller;


import com.sliit.event_photography_management_system.entity.Payment;
import com.sliit.event_photography_management_system.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.createPayment(payment);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }
    @GetMapping("/{paymentid}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long paymentid) {
        Payment payment = paymentService.getPayment(paymentid);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getPayments() {
        List<Payment>payments = paymentService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @PutMapping("/{paymentid}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long  paymentid, @RequestBody Payment payment) {
        Payment updatedPayment = paymentService.updatePayment(paymentid, payment);
        return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
    }

    @DeleteMapping("/{paymentid}")
    public ResponseEntity<HttpStatus> deletePayment(@PathVariable Long paymentid) {
        paymentService.deletePayment(paymentid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
