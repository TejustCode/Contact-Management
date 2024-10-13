package com.edu.contact_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.contact_manager.entity.Contact;
import com.edu.contact_manager.repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

	public Contact addContact(Contact contact) {
		return contactRepository.save(contact);
	}

	public List<Contact> getAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		return contacts;
	}

	public Contact getContactById(int id) {
		Contact id2 = contactRepository.findById(id).get();
		return id2;
	}

	public Contact updateContact(Contact contact) {
		return contactRepository.save(contact);
		
	}

	public Contact deleteContact(int id) {
		Optional<Contact> contact= contactRepository.findById(id);
		if (contact.isPresent()) {
			Contact contact2=contact.get();
			contactRepository.delete(contact2);
			return contact2;
		}else {
			return null;
		}
	}
}
