package com.sliit.event_photography_management_system.service;
import com.sliit.event_photography_management_system.entity.Package;
import java.util.List;

public interface PackageService {
    Package createPackage(Package pack);
    Package getPackage(Long packageid);
    List<Package> getAllPackages();
    Package updatePackage(Long packageid,Package pack);
    void deletePackage(Long packageid);

}
