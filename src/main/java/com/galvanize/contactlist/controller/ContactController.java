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

    @PostMapping("/contact")
    public ResponseEntity createContact(@RequestBody Contacts contacts)
    {
        contactService.createContact(contacts);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<Contacts>> listContactByGivenName(@RequestParam(required = false) String givenName,@RequestParam(required = false) String surname)
    {
        if(givenName!=null)
        return new ResponseEntity(contactService.findByGivenName(givenName), HttpStatus.OK);
        else if(givenName!=null && surname!=null)
            return new ResponseEntity(contactService.findByNames(givenName,surname), HttpStatus.OK);
        else
            return new ResponseEntity(contactService.findAllContacts(), HttpStatus.OK);

    }
    @GetMapping("/contacts/givenname")
    public ResponseEntity<Contacts> listContactByNames(@PathVariable("givenName") String givenName, @PathVariable("surname") String surname)
    {
            return new ResponseEntity(contactService.findByNames(givenName,surname), HttpStatus.OK);

    }

}
