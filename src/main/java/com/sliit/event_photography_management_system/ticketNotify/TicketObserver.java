package com.sliit.event_photography_management_system.ticketNotify;


import com.sliit.event_photography_management_system.entity.Ticket;

public interface TicketObserver {
    void update(Ticket ticket, String eventType);
}

