package com.sliit.event_photography_management_system.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long packageId;


    private String name;
    private double price;
    private String hours;
    private String type;
    private String description;

}
