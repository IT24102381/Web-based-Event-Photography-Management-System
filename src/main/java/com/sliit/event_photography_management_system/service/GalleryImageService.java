package com.sliit.event_photography_management_system.service;

import com.sliit.event_photography_management_system.entity.GalleryImage;
import com.sliit.event_photography_management_system.repository.GalleryImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class GalleryImageService {

    @Autowired
    private GalleryImageRepository repository;

    public GalleryImage uploadImage(MultipartFile file) throws IOException {
        GalleryImage img = new GalleryImage();
        img.setName(file.getOriginalFilename());
        img.setType(file.getContentType());
        img.setImageData(file.getBytes());
        return repository.save(img);
    }

    public List<GalleryImage> getAllImages() {
        return repository.findAll();
    }

    public byte[] getImageById(Long id) {
        return repository.findById(id)
                .map(GalleryImage::getImageData)
                .orElse(null);
    }

    public void deleteImage(Long id) {
        repository.deleteById(id);
    }
}

