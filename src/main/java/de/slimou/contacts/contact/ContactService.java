package de.slimou.contacts.contact;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> findByName(String forname, String lastname){
        return this.contactRepository.findByName(forname, lastname);
    }

}
