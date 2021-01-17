package de.slimou.contacts.controller;

import de.slimou.contacts.repository.ContactRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    private ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping(path = "/kontakte")
    public String uebersicht(Model model){
        model.addAttribute("contacts", contactRepository.findAll());
        return "contacts/contact-list";
    }

    @GetMapping(path = "/new-contact")
    public String hinzufuegen(){
        return "contacts/contact-add";
    }
}
