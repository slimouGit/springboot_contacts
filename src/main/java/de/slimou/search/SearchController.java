package de.slimou.search;

import de.slimou.contacts.Contact;
import de.slimou.contacts.ContactRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    private ContactRepository contactRepository;

    public SearchController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping(path = "/search-contact")
    public String sucheKontakt(Model model){
        model.addAttribute("searchForm", new Search());
        return "contacts/contact-search";
    }

    @PostMapping(path = "/search-contact")
    public String findeKontakt(@RequestParam("forname") String forname, @RequestParam("lastname") String lastname) {
        List<Contact> personListByName = this.contactRepository.findByName(forname, lastname);
        return "redirect:/search-contact";
    }

}
