package com.revature.Spring.payload.response;

import java.util.List;

public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private int id;
    private String first_name;
    private String last;
    private String username;
    private String email;
    private String title;
    private List<String> roles;

    /**
     * The JwtResponse constructor.
     * @param accessToken
     * @param id
     * @param username
     * @param email
     * @param title
     * @param roles
     */

    public JwtResponse(String accessToken, int id, String first_name, String last, String username, String email, String title, List<String> roles) {

        this.token = accessToken;
        this.id = id;
        this.first_name = first_name;
        this.last = last;
        this.username = username;
        this.email = email;
        this.title = title;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
