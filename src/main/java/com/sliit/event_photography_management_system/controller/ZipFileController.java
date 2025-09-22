package com.sliit.event_photography_management_system.controller;

import com.sliit.event_photography_management_system.entity.ZipFile;
import com.sliit.event_photography_management_system.service.ZipFileService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/zip")
@CrossOrigin(origins = "*")
public class ZipFileController {

    private final ZipFileService service;

    public ZipFileController(ZipFileService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public ZipFile uploadZip(@RequestParam("file") MultipartFile file,
                             @RequestParam("customerEmail") String customerEmail,
                             @RequestParam(value = "eventId", required = false) Long eventId) throws IOException {
        return service.uploadFile(file, customerEmail, eventId);
    }

    @GetMapping("/customer/{email}")
    public List<ZipFile> getZipsByCustomer(@PathVariable String email) {
        return service.getFilesByCustomer(email);
    }


    @GetMapping("/all")
    public List<ZipFile> getAllZips() {
        return service.getAllFiles();
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadZip(@PathVariable Long id) {
        ZipFile zip = service.getFileById(id);
        if (zip == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + zip.getFileName() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(zip.getFileData());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteZip(@PathVariable Long id) {
        boolean deleted = service.deleteFile(id);
        if (deleted) {
            return ResponseEntity.ok("File deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ZipFile> updateZip(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "customerEmail", required = false) String customerEmail,
            @RequestParam(value = "eventId", required = false) Long eventId
    ) throws IOException {
        ZipFile updated = service.updateFile(id, file, customerEmail, eventId);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }


}
