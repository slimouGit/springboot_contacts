package de.slimou.contacts.contact;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ContactController {

    private ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping(path = "/kontakte")
    public String uebersicht(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
        return "contacts/contact-list";
    }

    @RequestMapping("/contact-detail")
    public String detailansicht(@RequestParam("id") int id, Model model) {
        model.addAttribute("id", contactRepository.findById(id).get().getId());
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

    @GetMapping(path = "/edit-view/{id}")
    public String viewContact(Model model, @PathVariable Integer id) {
        Optional<Contact> c = contactRepository.findById(id);
        if (c.isPresent()) {
            model.addAttribute("contact", c.get());
            model.addAttribute("forname", c.get().getForname());
            model.addAttribute("lastname", c.get().getLastname());
            model.addAttribute("phone", c.get().getPhone());
            model.addAttribute("email", c.get().getEmail());
            model.addAttribute("birthday", c.get().getBirthday());
            model.addAttribute("street", c.get().getStreet());
            model.addAttribute("housenumber", c.get().getHousenumber());
            model.addAttribute("zipcode", c.get().getZipcode());
            model.addAttribute("location", c.get().getLocation());
        } else {
            return "contacts/contact-list";
        }
        return "contacts/contact-detail";
    }

    @GetMapping(path = "/new-contact")
    public String hinzufuegen(Model model) {
        Contact c = new Contact();
        model.addAttribute("contact", c);
        return "contacts/contact-add";
    }

    @PostMapping(path = "/new-contact")
    public String speicherKontakt(Model model, @Valid @ModelAttribute("contact") Contact c, BindingResult results, RedirectAttributes redirAttrs) {
        if (results.hasErrors()) {
            return "contacts/contact-add";
        }
        contactRepository.save(c);
        redirAttrs.addFlashAttribute("success", "Kontakt wurde erstellt");

        return "redirect:/kontakte";
    }

    @GetMapping(path = "/edit-contact/{id}")
    public String bearbeiten(Model model, @PathVariable Integer id) {
        Optional<Contact> c = contactRepository.findById(id);
        if (c.isPresent()) {
            model.addAttribute("contact", c.get());
        } else {
            return "contacts/contact-list";
        }
        return "contacts/contact-edit";
    }

    @PostMapping(path = "/edit-contact/{id}")
    public String aktualisiereKontakt(Model model, @Valid @ModelAttribute("contact") Contact c, BindingResult results, @PathVariable Integer id) {
        if (results.hasErrors()) {
            return "contacts/edit-contact";
        }
        contactRepository.save(c);
        return "redirect:/kontakte";
    }

    @GetMapping(path = "/delete-contact/{id}")
    public String loeschen(Model model, @PathVariable Integer id, RedirectAttributes redirAttrs) {
        Optional<Contact> c = contactRepository.findById(id);
        contactRepository.deleteById(id);
        redirAttrs.addFlashAttribute("success", c.get().getLastname() + " wurde erolgreich gelöscht");
        return "redirect:/kontakte";
    }



}
