package com.revature.Spring.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class TestController maps to "/api/test"
 * <br><br>
 * <ul>
 *      <li>allAccess</li>
 *      <li>guserAccess</li>
 *      <li>moderatorAccess</li>
 *      <li>adminAccess</li>
 *  </ul>
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    /**
     * allAccess maps to /all
     * @return String containing "Public Content."
     */
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    /**
     * userAccess maps to /user
     * preauthorize user Role for values 'USER', 'MODERATOR' or 'ADMIN'
     * @return String containing "User Content."
     */
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    /**
     * moderatorAccess maps to /mod
     * preauthorize user Role for value 'MODERATOR'
     * @return String containing "Moderator Board."
     */
    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    /**
     * adminAccess maps to /admin
     * preauthorize user Role for value 'ADMIN'
     * @return String containing "Admin Board."
     */
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}