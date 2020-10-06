package com.r0ngsh3n.restful.template.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "USER")
@NamedQuery(name = "User.findByEmail", query = "Select u from USER where u.email = ?1")
public class User {
    @Id @GeneratedValue
    Long Id;

    @NotEmpty(message = "User Name can not be empty")
    @Size(min = 4, max = 20, message = "user name has to be 4 - 20")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Password can not be empty")
    @Size(min = 4, max = 20, message = "password has to be 4 - 20")
    @Column(name = "password")
    private String password;

    @NotEmpty(message = "Email can not be emtpy")
    @Email
    @Column(name = "email")
    private String email;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @ElementCollection
    private List<Item> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


