package com.sliit.event_photography_management_system.service;

import com.sliit.event_photography_management_system.entity.ZipFile;
import com.sliit.event_photography_management_system.repository.ZipFileRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ZipFileService {

    private final ZipFileRepository repository;

    public ZipFileService(ZipFileRepository repository) {
        this.repository = repository;
    }

    public ZipFile uploadFile(MultipartFile file, String customerEmail, Long eventId) throws IOException {
        ZipFile zip = new ZipFile();
        zip.setFileName(file.getOriginalFilename());
        zip.setCustomerEmail(customerEmail);
        zip.setEventId(eventId);
        zip.setUploadDate(LocalDateTime.now());
        zip.setFileData(file.getBytes());
        return repository.save(zip);
    }

    public List<ZipFile> getAllFiles() {
        return repository.findAll();
    }

    public List<ZipFile> getFilesByCustomer(String email) {
        return repository.findByCustomerEmail(email);
    }

    public ZipFile getFileById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public boolean deleteFile(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }




    public ZipFile updateFile(Long id, MultipartFile file, String customerEmail, Long eventId) throws IOException {
        return repository.findById(id).map(existing -> {
            try {
                existing.setFileName(file.getOriginalFilename());
                existing.setFileData(file.getBytes());
                existing.setUploadDate(LocalDateTime.now());

                if (customerEmail != null) existing.setCustomerEmail(customerEmail);
                if (eventId != null) existing.setEventId(eventId);

                return repository.save(existing);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).orElse(null);
    }


}
