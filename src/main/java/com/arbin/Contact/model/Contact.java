package com.arbin.Contact.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Entity
@Data
public class Contact {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private Long id;
private String name;
private String email;
private String phone;
private String address;
private String birthday;
private String occupation;
private String tags;
private String notes;
private String createdAt;
private String updatedAt;
}
