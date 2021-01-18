package de.slimou.contacts.controller;

import de.slimou.contacts.repository.ContactRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/contact-detail")
    public String detailansicht(@RequestParam("id") int id, Model model) {
        model.addAttribute("forname", contactRepository.findById(id).get().getForname());
        model.addAttribute("lastname", contactRepository.findById(id).get().getLastname());
        model.addAttribute("phone", contactRepository.findById(id).get().getPhone());
        model.addAttribute("email", contactRepository.findById(id).get().getEmail());
        model.addAttribute("birthday", contactRepository.findById(id).get().getBirthday());
        model.addAttribute("street", contactRepository.findById(id).get().getStreet());
        model.addAttribute("housenumber", contactRepository.findById(id).get().getHousenumber());
        model.addAttribute("zipcode", contactRepository.findById(id).get().getZipcode());
        model.addAttribute("location", contactRepository.findById(id).get().getLocation());
        return "contacts/contact-detail";
    }
}
