package com.sliit.event_photography_management_system.serviceImpl;


import com.sliit.event_photography_management_system.entity.Photographer;
import com.sliit.event_photography_management_system.repository.PhotographerRepository;
import com.sliit.event_photography_management_system.service.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotographerImpl implements PhotographerService {
    @Autowired
    private PhotographerRepository photographerRepository;

    @Override
    public Photographer createPhotographer(Photographer photographer){
        return photographerRepository.save(photographer);
    }
    @Override
    public Photographer getPhotographer(Long pid){
        Optional<Photographer>photographer = photographerRepository.findById(pid);
        if(photographer.isPresent()){
            return photographer.get();
        }else {
            throw new RuntimeException("Booking not found with id " + pid);
        }
    }
    @Override
    public List<Photographer> getAllPhotographers(){
        return photographerRepository.findAll();
    }

    @Override
    public Photographer updatePhotographer(Long pid, Photographer photographer){
        Photographer existingPhotographer = getPhotographer(pid);
        existingPhotographer.setFirstName(photographer.getFirstName());
        existingPhotographer.setLastName(photographer.getLastName());
        existingPhotographer.setNic(photographer.getNic());
        existingPhotographer.setEmail(photographer.getEmail());
        existingPhotographer.setPhone(photographer.getPhone());
        existingPhotographer.setJobTitle(photographer.getJobTitle());
        return photographerRepository.save(existingPhotographer);
    }

    @Override
    public void deletePhotographer(Long pid){
       Photographer photographer = getPhotographer(pid);
        photographerRepository.delete(photographer);
    }









}
