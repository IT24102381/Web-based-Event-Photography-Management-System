package com.sliit.event_photography_management_system.ticketNotify;


import com.sliit.event_photography_management_system.entity.Ticket;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketSubject {

    private final List<TicketObserver> observers = new ArrayList<>();

    public void addObserver(TicketObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TicketObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Ticket ticket, String eventType) {
        for (TicketObserver observer : observers) {
            observer.update(ticket, eventType);
        }
    }
}
