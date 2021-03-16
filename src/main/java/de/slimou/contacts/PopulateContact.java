package de.slimou.contacts;

import de.slimou.contacts.model.Contact;
import de.slimou.contacts.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PopulateContact implements CommandLineRunner {
    private ContactRepository contactRepository;

    public PopulateContact(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Contact contact = new Contact();
        contact.setForname("Marcus");
        contact.setLastname("Quandt");
        contact.setPhone("01602515893");
        contact.setEmail("-------------");
        contact.setBirthday(LocalDate.of(1972, 12, 30));
        contact.setStreet("Rusolf-Diesel-Straße");
        contact.setHousenumber("10");
        contact.setZipcode(64331);
        contact.setLocation("Weiterstadt");
        contactRepository.save(contact);

    }
}
