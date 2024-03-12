package net.javaguides.SpringbootBackend.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "employees")
public class Employee {

    public Employee() {
    }

    public Employee(long id, String firstName, String secondName, String emailId) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.emailId = emailId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmailId() {
        return emailId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "email_id")
    private String emailId;

}