package com.sliit.event_photography_management_system.controller;


import com.sliit.event_photography_management_system.entity.Photographer;
import com.sliit.event_photography_management_system.service.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photographers")
@CrossOrigin(origins = "*")
public class PhotographerController {

    @Autowired
    private PhotographerService photographerService;

    @PostMapping
    public ResponseEntity<Photographer>createPhotographer(@RequestBody Photographer photographer){
        Photographer createdPhotographer = photographerService.createPhotographer(photographer);
        return new ResponseEntity<>(createdPhotographer, HttpStatus.CREATED);
    }
    @GetMapping("/{pid}")
    public ResponseEntity<Photographer>getPhotographer(@RequestParam Long pid){
        Photographer photographer = photographerService.getPhotographer(pid);
        return new ResponseEntity<>(photographer, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Photographer>> getAllPhotographers(){
        List<Photographer> photographers = photographerService.getAllPhotographers();
        return new ResponseEntity<>(photographers, HttpStatus.OK);
    }
    @PutMapping("/{pid}")
    public ResponseEntity<Photographer>updatePhotographer(@PathVariable Long pid, @RequestBody Photographer photographer){
        Photographer updatedPhotographer = photographerService.updatePhotographer(pid, photographer);
        return new ResponseEntity<>(updatedPhotographer, HttpStatus.OK);
    }
    @DeleteMapping("/{pid}")
    public ResponseEntity<Photographer>deletePhotographer(@PathVariable Long pid){
        photographerService.deletePhotographer(pid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }







}
