package com.NewProject.Model;


import javax.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int id;
        @Column(nullable = false)
        private String name;
        @Column(nullable = false)
        private String phone;
        @Column(nullable = false)
        private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Contact(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Contact() {
    }
}
