package com.galvanize.contactlist.controller;

import com.galvanize.contactlist.domain.Contacts;
import com.galvanize.contactlist.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;
    @GetMapping("/contacts")
    public ResponseEntity<List<Contacts>> listAllContacts(){
        return new ResponseEntity(contactService.findAllContacts(), HttpStatus.OK);
    }
}