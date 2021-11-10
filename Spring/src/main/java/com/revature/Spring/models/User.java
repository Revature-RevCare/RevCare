package com.revature.Spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity model class annotated to connext to the DB table "users".
 */
@Entity
@Table(name = "users")
public class User {

    //Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    private String first_name;

    @Column(name = "last_name")
    private String last;

    private String education;

    private String title;

    private String email;

    private String username;

    private String password;

    private String phone_number;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))

    private Set<Role> roles = new HashSet<>();

    // Constructors here
    public User() {
    }

    /**
     * User all arg Constructor
     * @param user_id
     * @param first_name
     * @param last
     * @param education
     * @param title
     * @param email
     * @param username
     * @param password
     * @param phone_number
     */
    public User(int user_id, String first_name, String last, String education,
                String title, String email, String username, String password, String phone_number) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last = last;
        this.education = education;
        this.title = title;
        this.email = email;
        this.username = username;
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

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    // Override the to string method here

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", last='" + last + '\'' +
                ", education='" + education + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }




//    @Override
//    public String toString() {
//        return "User{" +
//                "user_id=" + user_id +
//                ", first_name='" + first_name + '\'' +
//                ", last_name='" + last + '\'' +
//                ", education='" + education + '\'' +
//                ", title='" + title + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", phone_number='" + phone_number + '\'' +
//                '}';
//    }
}
