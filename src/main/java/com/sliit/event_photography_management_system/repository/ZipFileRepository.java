package com.sliit.event_photography_management_system.repository;

import com.sliit.event_photography_management_system.entity.ZipFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZipFileRepository extends JpaRepository<ZipFile, Long> {
    List<ZipFile> findByCustomerEmail(String email);
}
