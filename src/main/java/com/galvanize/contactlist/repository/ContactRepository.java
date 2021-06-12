package com.galvanize.contactlist.repository;

import com.galvanize.contactlist.domain.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contacts,Long> {
}
