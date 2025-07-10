package com.arbin.Contact.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arbin.Contact.model.Contact;
import com.arbin.Contact.repository.ContactRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactService {
private ContactRepository contactRepository;

//Create a new contact
public Contact createContact(Contact contact) {
    return contactRepository.save(contact);
}

//Retrive all contacts
public List<Contact> getAllContacts() {
    return contactRepository.findAll();
}

//Retrieve a contact by ID
public Optional<Contact> getContactById(Long id) {
    return contactRepository.findById(id);
}

//Update an existing contact
public Contact updateContact(Long id, Contact contactToUpdate) {
return contactRepository.findById(id)
        .map(contact -> {
            contact.setName(contactToUpdate.getName());
            contact.setEmail(contactToUpdate.getEmail());
            contact.setPhone(contactToUpdate.getPhone());
            contact.setAddress(contactToUpdate.getAddress());
            contact.setBirthday(contactToUpdate.getBirthday());
            contact.setOccupation(contactToUpdate.getOccupation());
            contact.setTags(contactToUpdate.getTags());
            contact.setNotes(contactToUpdate.getNotes());
            return contactRepository.save(contact);
        })
        .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));
}

//Delete a contact by ID
public void deleteContact(Long id) {
    if (!contactRepository.existsById(id)) {
        throw new RuntimeException("Contact not found with id: " + id);
    }
    contactRepository.deleteById(id);
}


}
