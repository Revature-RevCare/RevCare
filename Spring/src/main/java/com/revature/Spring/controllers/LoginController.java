package com.revature.Spring.controllers;


import com.revature.Spring.models.ERole;
import com.revature.Spring.models.Role;
import com.revature.Spring.models.User;
import com.revature.Spring.payload.request.LoginRequest;
import com.revature.Spring.payload.request.SignupRequest;
import com.revature.Spring.payload.response.JwtResponse;
import com.revature.Spring.payload.response.MessageResponse;
import com.revature.Spring.repositories.RoleRepo;
import com.revature.Spring.repositories.UserRepo;
import com.revature.Spring.security.JwtUtils;
import com.revature.Spring.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * LoginController class is annotated for a RestController with RequestMapping at "/api/auth"
 * <br><br>
 * <b>Methods</b>
 * <ul>
 *      <li>authenticateUser Authenticates the user.</li>
 *      <li>registerUser Registers a new user. Signup.</li>
 *  </ul>
 */
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    /**
     * authenticateUser maps to "/signin".
     * @param loginRequest
     * @return a ResponseEntity containing user id, username, email, title, and roles.
     */
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){ //took out loginrequest
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        System.out.println(jwt);
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUser_id(),
                userDetails.getFirst_name(),
                userDetails.getLast(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getTitle(),
                roles));

    }

    /**
     * registerUser maps to "/signup" and creates a new user containing first name, last name, education, username, Email,
     *      * password, phone number, title and roles.
     * @param signupRequest
     * @return errors or a ResponseEntity with success.
     */
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest){

        if (userRepo.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepo.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User();
        user.setFirst_name(signupRequest.getFirst_name());
        user.setLast(signupRequest.getLast());
        user.setEducation(signupRequest.getEducation());
        user.setUsername(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(encoder.encode(signupRequest.getPassword()));
        user.setPhone_number(signupRequest.getPhone_number());
        user.setTitle(signupRequest.getTitle());
//        user.setRoles(signupRequest.getRole("ADMIN"));

        Set<Role> strRoles = user.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepo.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                if ("admin".equals(roles)) {
                    Role adminRole = roleRepo.findByName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);
                } else if ("mod".equals(roles)) {
                    Role modRole = roleRepo.findByName(ERole.ROLE_MODERATOR)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(modRole);
                } else {
                    Role userRole = roleRepo.findByName(ERole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepo.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }


}
