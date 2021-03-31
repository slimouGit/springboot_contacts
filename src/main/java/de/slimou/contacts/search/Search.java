package de.slimou.contacts.search;

public class Search {
    private String forname;
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
