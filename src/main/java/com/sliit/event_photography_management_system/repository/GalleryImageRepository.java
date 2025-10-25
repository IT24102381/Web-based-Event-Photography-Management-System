package com.sliit.event_photography_management_system.repository;

import com.sliit.event_photography_management_system.entity.GalleryImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryImageRepository extends JpaRepository<GalleryImage, Long> {
}
