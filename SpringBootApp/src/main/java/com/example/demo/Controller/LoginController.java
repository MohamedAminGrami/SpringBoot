package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Return the name of your login page
    }
    
    @PostMapping("/login")
    public String processLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
        User user = userRepository.findByEmail(email);
        
        if (user != null && user.getPassword().equals(password)) {
            // Authentication successful
            return "redirect:/"; // Redirect to the home page or any other authenticated page
        } else {
            // Authentication failed
            return "redirect:/login?error"; // Redirect back to the login page with an error parameter
        }
    }
}
