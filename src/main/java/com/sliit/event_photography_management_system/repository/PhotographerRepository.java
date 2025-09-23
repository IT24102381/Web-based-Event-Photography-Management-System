package com.sliit.event_photography_management_system.repository;

import com.sliit.event_photography_management_system.entity.Photographer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotographerRepository extends JpaRepository<Photographer, Long> {
}
