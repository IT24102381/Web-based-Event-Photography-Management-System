package com.sliit.event_photography_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZipFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String customerEmail;   // Who owns this gallery
    private Long eventId;           // Optional: link to event

    private LocalDateTime uploadDate;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] fileData;
}
