package com.arbin.Contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arbin.Contact.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    // Additional query methods can be defined here if needed

}
