package com.sliit.event_photography_management_system.repository;


import com.sliit.event_photography_management_system.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  BookingRepository extends JpaRepository<Booking, Long> {
}
