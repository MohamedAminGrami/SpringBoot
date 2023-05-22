package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/register")
    public String showRegistrationPage() {
        return "register"; // Return the name of your registration page
    }
    
    @PostMapping("/register")
    public String processRegistration(@RequestParam("email") String email, @RequestParam("password") String password) {
        // Check if a user with the given email already exists
        if (userRepository.findByEmail(email) != null) {
            // User with the same email already exists, handle the error
            return "redirect:/register?error"; // Redirect back to the registration page with an error parameter
        }
        
        // Create a new user
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        
        // Save the user in the database
        userRepository.save(user);
        
        // Redirect to the login page after successful registration
        return "redirect:/login";
    }
}

