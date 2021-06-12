package com.galvanize.contactlist.repository;

import com.galvanize.contactlist.domain.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contacts,Long> {
//    @Query("select * from contacts c where c.givenName = givenName and c.surname=surname")
    List<Contacts> findByGivenName(String givenName);
//    @Query("select * from contacts c where c.givenName = 'test'")
//    List<Contacts> findByNames(String givenName, String surname);

    @Query("SELECT c FROM contacts c WHERE c.givenName LIKE %:givenName% and c.surname LIKE %:surname% ")
    List<Contacts> findByNames(@Param("givenName") String givenName,@Param("surname") String surname );
}
