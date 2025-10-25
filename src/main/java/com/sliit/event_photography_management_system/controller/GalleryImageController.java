package com.sliit.event_photography_management_system.controller;


import com.sliit.event_photography_management_system.entity.GalleryImage;
import com.sliit.event_photography_management_system.service.GalleryImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/gallery")
@CrossOrigin(origins = "*")
public class GalleryImageController {

    @Autowired
    private GalleryImageService service;

    @PostMapping("/upload")
    public ResponseEntity<GalleryImage> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("Received file: " + file.getOriginalFilename());
        return ResponseEntity.ok(service.uploadImage(file));
    }

    @GetMapping
    public ResponseEntity<List<GalleryImage>> getAllImages() {
        return ResponseEntity.ok(service.getAllImages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        byte[] imageData = service.getImageById(id);
        if (imageData == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        service.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}

