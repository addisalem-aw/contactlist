package com.galvanize.contactlist.service;

import com.galvanize.contactlist.domain.Contacts;
import com.galvanize.contactlist.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;
    public List<Contacts> findAllContacts() {
        return contactRepository.findAll();
    }

    public void createContact(Contacts contacts)
    {
        contactRepository.save(contacts);
    }

    public List<Contacts> findByGivenName(String givenName) {
        return contactRepository.findByGivenName(givenName);
    }

    public List<Contacts> findByNames(String givenName, String surname) {
        return contactRepository.findByNames(givenName,surname);
    }
}
