package de.slimou.contacts.search;

import javax.validation.constraints.NotBlank;

public class Search {
    @NotBlank(message = "Bitte einen Vornamen angeben")
    private String forname;
    @NotBlank(message = "Bitte einen Nachnamen angeben")
    private String lastname;

    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Search(String forname, String lastname) {
        this.forname = forname;
        this.lastname = lastname;
    }

    public Search() {
    }
}
