package com.sliit.event_photography_management_system.service;

import com.sliit.event_photography_management_system.entity.Photographer;

import java.util.List;

public interface PhotographerService {
    Photographer createPhotographer(Photographer photographer);

    Photographer getPhotographer(Long pid);

    List<Photographer> getAllPhotographers();

    Photographer updatePhotographer(Long pid, Photographer photographer);

    void deletePhotographer(Long pid);
}
