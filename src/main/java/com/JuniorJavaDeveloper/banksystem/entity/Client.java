package com.JuniorJavaDeveloper.banksystem.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "firstname")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "lastname")
    private String lastName;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "fathername")
    private String fatherName;

    @NotNull
    @Email
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "pasportnumber")
    private String pasportNumber;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "phonenumber")
    private String phoneNumber;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasportNumber() {
        return pasportNumber;
    }

    public void setPasportNumber(String pasportNumber) {
        this.pasportNumber = pasportNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return getLastName() + " " + getFirstName() + " " + getFatherName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
