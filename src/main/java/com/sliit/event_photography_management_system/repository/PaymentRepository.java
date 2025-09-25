package com.sliit.event_photography_management_system.repository;

import com.sliit.event_photography_management_system.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
