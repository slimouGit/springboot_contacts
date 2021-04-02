package de.slimou.contacts.contact;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Bitte einen Vornamen angeben")
    @Size(min = 3, message = "Der Vorname muss mindestens 3 Zeichen einthalten")
    @Column(name = "forname")
    private String forname;

    @NotBlank(message = "Bitte einen Nachnamen angeben")
    @Column(name = "lastname")
    private String lastname;

    @NotBlank(message = "Bitte eine Telefonnummer angeben")
    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "street")
    private String street;

    @Column(name = "housenumber")
    private String housenumber;

    @Column(name = "zipcode")
    private Integer zipcode;

    @Column(name = "location")
    private String location;

    public Contact() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", forname='" + forname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", street='" + street + '\'' +
                ", housenumber='" + housenumber + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return id != null ? id.equals(contact.id) : contact.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
