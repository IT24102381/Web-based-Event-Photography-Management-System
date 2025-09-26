package com.sliit.event_photography_management_system.service;
import com.sliit.event_photography_management_system.entity.Ticket;
import java.util.List;

public interface TicketService {
    Ticket createTicket(Ticket ticket);
    Ticket getTicket(Long Tid);
    List<Ticket> getAllTickets();
    Ticket updateTicket(Long Tid, Ticket ticket);

    void deleteTicket(Long Tid);

}
