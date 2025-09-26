package com.sliit.event_photography_management_system.controller;
import com.sliit.event_photography_management_system.entity.Ticket;
import com.sliit.event_photography_management_system.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "*")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.createTicket(ticket);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

    @GetMapping("/{Tid}")
    public ResponseEntity<Ticket> getTicket(@PathVariable Long Tid) {
        Ticket ticket = ticketService.getTicket(Tid);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets()
    {
        List<Ticket> tickets = ticketService.getAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
    @PutMapping("/{Tid}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long Tid, @RequestBody Ticket ticket) {
        Ticket updatedTicket = ticketService.updateTicket(Tid, ticket);
        return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
    }

    @DeleteMapping("/{Tid}")
    public ResponseEntity<String> deleteTicket(@PathVariable Long Tid) {
        ticketService.deleteTicket(Tid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

