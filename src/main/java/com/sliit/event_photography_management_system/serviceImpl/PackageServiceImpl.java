package com.sliit.event_photography_management_system.serviceImpl;
import com.sliit.event_photography_management_system.entity.Package;
import com.sliit.event_photography_management_system.repository.PackageRepository;
import com.sliit.event_photography_management_system.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageRepository packageRepository;

    @Override
    public Package createPackage(Package pack){
        return packageRepository.save(pack);
    }

    @Override
    public Package getPackage(Long packageid){
        Optional<Package> pack = packageRepository.findById(packageid);
        if(pack.isPresent()){
            return pack.get();
        }
        else {
            throw new RuntimeException("Package not found" + packageid);
        }
    }
    public List<Package> getAllPackages(){
        return packageRepository.findAll();
    }

    @Override
    public Package updatePackage(Long packageid,Package pack){
        Package existingPackage = getPackage(packageid);
        existingPackage.setName(pack.getName());
        existingPackage.setPrice(pack.getPrice());
        existingPackage.setHours(pack.getHours());
        existingPackage.setType(pack.getType());
        existingPackage.setDescription(pack.getDescription());
        return packageRepository.save(existingPackage);
    }

    @Override
    public void deletePackage(Long packageid) {
        Package existingPackage = getPackage(packageid);
        packageRepository.delete(existingPackage);
    }
}
