package com.revature.Spring.models;

import javax.persistence.*;

@Entity
@Table(name = "users")

public class User {

    //Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    private String first_name;

    private String last_name;

    private String education;

    private String title;

    private String email;

    private String password;

    private String phone_number;

    // Constructors here
    public User() {
    }

    public User(int user_id, String first_name, String last_name, String education,
                String title, String email, String password, String phone_number) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.education = education;
        this.title = title;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
    }


    // Getters and Setters
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    // Override the to string method here
    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", education='" + education + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
