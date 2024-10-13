package com.edu.contact_manager.controller;

import com.edu.contact_manager.entity.Contact;
import com.edu.contact_manager.entity.ContactResponse;
import com.edu.contact_manager.service.ContactService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*") 
public class ContactController {

    @Autowired
    private ContactService contactService;
    
    @PostMapping(value = "/contact")
    protected ResponseEntity<ContactResponse<Contact>> addContact(@RequestBody Contact contact) {
		Contact contact2 = contactService.addContact(contact);
		ContactResponse<Contact> contactResponse = new ContactResponse<>();
		contactResponse.setMessage("Contact is added");
		contactResponse.setHttpStatusCode(HttpStatus.CREATED.value());
		contactResponse.setData(contact2);
		return new ResponseEntity<ContactResponse<Contact>>(contactResponse, HttpStatus.CREATED);
	}
    
    @GetMapping(value = "/contacts")
    protected List<Contact> getAllContacts() {
		List<Contact> allContacts = contactService.getAllContacts();
		return allContacts;
	}
    
    @GetMapping(value = "/contact/{id}")
    protected Contact getContactById(@PathVariable(name = "id") int id) {
		Contact byId = contactService.getContactById(id);
		return byId;
	}
    
    @PutMapping(value = "/contact")
    protected ResponseEntity<ContactResponse<Contact>> updateContact(@RequestBody Contact contact) {
		Contact updatedContact = contactService.updateContact(contact);
		ContactResponse<Contact> contactResponse = new ContactResponse<>();
		contactResponse.setMessage("Contact Updated");
		contactResponse.setHttpStatusCode(HttpStatus.CREATED.value());
		contactResponse.setData(updatedContact);
		return new ResponseEntity<ContactResponse<Contact>>(contactResponse, HttpStatus.CREATED);
	}
    
    @DeleteMapping(value = "/contact/{id}")
    protected ResponseEntity<ContactResponse<Contact>> deleteContact(@PathVariable(name = "id") int id) {
		 Contact deletedContact = contactService.deleteContact(id);
		 ContactResponse<Contact> contactResponse = new ContactResponse<>();
		 if (deletedContact !=null) {
			 contactResponse.setMessage("Contact Deleted");
			 contactResponse.setHttpStatusCode(HttpStatus.OK.value());
			 contactResponse.setData(deletedContact);
			 return new ResponseEntity<ContactResponse<Contact>>(contactResponse, HttpStatus.OK);
		}else {
			 contactResponse.setMessage("Contact Not Found");
			 contactResponse.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			 contactResponse.setData(deletedContact);
			 return new ResponseEntity<ContactResponse<Contact>>(contactResponse, HttpStatus.NOT_FOUND);
		}
	}
}
