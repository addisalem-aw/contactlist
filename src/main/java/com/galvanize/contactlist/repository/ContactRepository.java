package com.galvanize.contactlist.repository;

import com.galvanize.contactlist.domain.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contacts,Long> {
   // List<Contacts> findByName(String givenName, String surname);
    @Query("select * from contacts c where c.givenName = givenName and c.surname=surname")
    List<Contacts> findByName(String givenName, String surname);
}
