package com.galvanize.contactlist.repository;

import com.galvanize.contactlist.domain.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contacts,Long> {
}
