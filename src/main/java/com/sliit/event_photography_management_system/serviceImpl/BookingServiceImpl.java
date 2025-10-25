package com.sliit.event_photography_management_system.serviceImpl;

import com.sliit.event_photography_management_system.entity.Booking;
import com.sliit.event_photography_management_system.eventNotify.BookingEventNotifier;
import com.sliit.event_photography_management_system.eventNotify.BookingObserver;
import com.sliit.event_photography_management_system.repository.BookingRepository;
import com.sliit.event_photography_management_system.service.BookingService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BookingEventNotifier bookingNotifier;
    @Autowired
    private List<BookingObserver> bookingObservers;


    @PostConstruct
    public void initObservers() {
        bookingObservers.forEach(bookingNotifier::registerObserver);
    }

    @Override
    public Booking createBooking(Booking booking){
        Booking saved = bookingRepository.save(booking);
        bookingNotifier.notifyObservers(saved);
        return saved;
    }
    @Override
    public Booking getBooking(Long id){
        Optional<Booking> booking = bookingRepository.findById(id);
        if(booking.isPresent()){
            return booking.get();
        }else {
            throw new RuntimeException("Booking not found with id " + id);
        }
    }
    @Override
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    @Override
    public Booking updateBooking(Long id,Booking booking){
        Booking existingBooking = getBooking(id);
        existingBooking.setName(booking.getName());
        existingBooking.setEmail(booking.getEmail());
        existingBooking.setPhone(booking.getPhone());
        existingBooking.setLocation(booking.getEventType());
        existingBooking.setDate(booking.getDate());
        existingBooking.setTime(booking.getTime());
        existingBooking.setLocation(booking.getLocation());
        existingBooking.setPhotographer(booking.getPhotographer());
        existingBooking.setPackageType(booking.getPackageType());
        existingBooking.setStatus(booking.getStatus());
        return bookingRepository.save(existingBooking);
    }
    @Override
    public void deleteBooking(Long id){
        Booking booking = getBooking(id);
        bookingRepository.delete(booking);
    }


}

