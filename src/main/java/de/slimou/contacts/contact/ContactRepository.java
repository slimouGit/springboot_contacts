package de.slimou.contacts.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    @Query("SELECT c FROM Contact c WHERE c.forname = :forname AND c.lastname = :lastname")
    List<Contact> findByName(@Param("forname") String forname, @Param("lastname") String lastname);
}
