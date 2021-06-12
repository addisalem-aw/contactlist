package com.galvanize.contactlist.controller;

import com.galvanize.contactlist.domain.Contacts;
import com.galvanize.contactlist.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;
    @GetMapping("/contacts")
    public ResponseEntity<List<Contacts>> listAllContacts(){
        return new ResponseEntity(contactService.findAllContacts(), HttpStatus.OK);
    }
    @PostMapping("/contact")
    public ResponseEntity createContact(@RequestBody Contacts contacts)
    {
        contactService.createContact(contacts);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/contacts/{givenname}/{surnname}")
    public ResponseEntity<List<Contacts>> listContactByName(@PathVariable("givenname") String givenname,
                                                            @PathVariable("surname") String surname)
    {

        return new ResponseEntity(contactService.findByName(givenname,surname), HttpStatus.OK);
    }

}
