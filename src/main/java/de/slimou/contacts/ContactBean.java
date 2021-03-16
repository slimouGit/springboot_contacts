package de.slimou.contacts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactBean {

    private String testContact;

    {
        this.testContact = "Mimi";
    }

    @GetMapping("/values")
    public String testContact(Model model) {
        String value = this.testContact;
        model.addAttribute("values", value);
        Integer numberOfEverything = 42;
        model.addAttribute("number", numberOfEverything);
        return "contacts/contact-value";
    }




}
