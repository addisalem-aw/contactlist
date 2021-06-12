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
}
