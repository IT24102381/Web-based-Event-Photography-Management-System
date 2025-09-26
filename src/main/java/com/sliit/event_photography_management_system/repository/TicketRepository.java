package com.sliit.event_photography_management_system.repository;

import com.sliit.event_photography_management_system.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
