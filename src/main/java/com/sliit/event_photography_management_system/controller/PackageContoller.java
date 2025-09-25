package com.sliit.event_photography_management_system.controller;

import  com.sliit.event_photography_management_system.entity.Package;
import com.sliit.event_photography_management_system.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
@CrossOrigin(origins = "*")
public class PackageContoller {

    @Autowired
    private PackageService packageService;


    @PostMapping
    public ResponseEntity<Package> createPackage(@RequestBody Package pack){
        Package createdPackage  = packageService.createPackage(pack);
        return new ResponseEntity<>(createdPackage, HttpStatus.CREATED);
    }

    @GetMapping("/{packageid}")
    public ResponseEntity<Package> getPackage(@PathVariable Long packageid){
        Package pack = packageService.getPackage(packageid);
        return new ResponseEntity<>(pack, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Package>> getAllPackages(){
        List<Package> packages = packageService.getAllPackages();
        return new ResponseEntity<>(packages, HttpStatus.OK);
    }


    @PutMapping("/{packageid}")
    public ResponseEntity<Package> updatePackage(@PathVariable Long packageid,@RequestBody Package pack){
        Package updatedPackage  = packageService.updatePackage(packageid,pack);
        return new ResponseEntity<>(updatedPackage, HttpStatus.OK);
    }

    @DeleteMapping("/{packageid}")
    public ResponseEntity<Package> deletePackage(@PathVariable Long packageid){
        packageService.deletePackage(packageid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
