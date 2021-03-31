package de.slimou.contacts.search;

import de.slimou.contacts.contact.Contact;
import de.slimou.contacts.contact.ContactRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SearchController {

    private ContactRepository contactRepository;

    public SearchController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping(path = "/search-contact")
    public String sucheKontakt(Model model) {
        model.addAttribute("searchForm", new Search());
        return "contacts/contact-search";
    }

    @PostMapping(path = "/search-contact")
    public String findeKontakt(@Valid @ModelAttribute("search") Search s, BindingResult results, @RequestParam("forname") String forname, @RequestParam("lastname") String lastname, RedirectAttributes redirAttrs) {
        List<Contact> contactList = this.contactRepository.findByName(forname, lastname);
        Integer id;
        if (results.hasErrors()) {
            return "redirect:/search-contact";
        }
        if (contactList.isEmpty()) {
            redirAttrs.addFlashAttribute("success", "Kontakt wurde nicht gefunden");
            return "redirect:/kontakte";
        } else {
            id = contactList.get(0).getId();
        }
        return "redirect:/edit-view/" + id;
    }

}
