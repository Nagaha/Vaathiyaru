package com.Mini_Project1.Vaathiyaru.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Email")
public class Email {
    private int id;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Email(int id, String email) {
        this.id = id;
        this.email = email;
    }
}
