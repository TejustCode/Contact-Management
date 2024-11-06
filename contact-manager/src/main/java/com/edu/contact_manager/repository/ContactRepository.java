package com.edu.contact_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.edu.contact_manager.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
