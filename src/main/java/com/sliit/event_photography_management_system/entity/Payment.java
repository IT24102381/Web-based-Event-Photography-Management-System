package com.sliit.event_photography_management_system.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment_new")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long payemntid;


    private String name;
    private String email;
    private String cardNumber;
    private LocalDate expiryDate;
    private int cvv;
    private String method;
    private String price;
    private String type;

}
