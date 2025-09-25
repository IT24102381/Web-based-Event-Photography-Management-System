package com.sliit.event_photography_management_system.repository;

import com.sliit.event_photography_management_system.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository  extends JpaRepository<Package, Long> {

}
