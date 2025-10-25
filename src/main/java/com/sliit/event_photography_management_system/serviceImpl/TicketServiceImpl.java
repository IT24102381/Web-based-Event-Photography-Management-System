package com.sliit.event_photography_management_system.serviceImpl;


import com.sliit.event_photography_management_system.entity.Ticket;
import com.sliit.event_photography_management_system.repository.TicketRepository;
import com.sliit.event_photography_management_system.service.TicketService;
import com.sliit.event_photography_management_system.ticketNotify.SupportOfficerEmailObserver;
import com.sliit.event_photography_management_system.ticketNotify.TicketCreaterEmailObserver;
import com.sliit.event_photography_management_system.ticketNotify.TicketSubject;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {


    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketSubject ticketSubject;

    @Autowired
    private TicketCreaterEmailObserver customerEmailObserver;

    @Autowired
    private SupportOfficerEmailObserver supportOfficerEmailObserver;

    @PostConstruct
    public void registerObservers() {
        ticketSubject.addObserver(customerEmailObserver);
        ticketSubject.addObserver(supportOfficerEmailObserver);
        System.out.println(" Ticket observers registered successfully");
    }



    @Override
    public Ticket createTicket(Ticket ticket) {
        Ticket created = ticketRepository.save(ticket);
        ticketSubject.notifyObservers(created, "CREATED");
        return created;
    }
    @Override
    public Ticket getTicket(Long Tid) {
        Optional<Ticket> ticket =ticketRepository.findById(Tid);
        if (ticket.isPresent()) {
            return ticket.get();
        }
        else {
            throw new RuntimeException("Ticket not found id "+Tid);
        }
    }
    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket updateTicket(Long Tid, Ticket ticket) {
        Ticket existingTicket = getTicket(Tid);
        existingTicket.setTname(ticket.getTname());
        existingTicket.setTemail(ticket.getTemail());
        existingTicket.setTphone(ticket.getTphone());
        existingTicket.setTsubject(ticket.getTsubject());
        existingTicket.setTmessage(ticket.getTmessage());
        existingTicket.setTstatus(ticket.getTstatus());
        Ticket updated = ticketRepository.save(existingTicket);
        ticketSubject.notifyObservers(updated, "UPDATED");
        return updated;
    }

    @Override
    public void deleteTicket(Long Tid) {
        Ticket ticket = getTicket(Tid);
        ticketRepository.delete(ticket);
    }


}





