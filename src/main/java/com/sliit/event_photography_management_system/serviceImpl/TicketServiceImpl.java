package com.sliit.event_photography_management_system.serviceImpl;


import com.sliit.event_photography_management_system.entity.Ticket;
import com.sliit.event_photography_management_system.repository.TicketRepository;
import com.sliit.event_photography_management_system.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {


    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
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
        return ticketRepository.save(existingTicket);
    }

    @Override
    public void deleteTicket(Long Tid) {
        Ticket ticket = getTicket(Tid);
        ticketRepository.delete(ticket);
    }


    }





