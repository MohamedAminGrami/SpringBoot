package com.example.demo.Controller;

import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/USER")
public class UserController {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;

    @Autowired
    public UserController(UserRepository userRepo, RoleRepository roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

//    @PostMapping("/login")
//    public String processLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
//        // Implement your login logic here
//        User user = userRepo.findByEmail(email); // Assuming you have a method in your UserRepository to find a user by email
//        if (user != null && user.getPassword().equals(password)) {
//            // User exists and the provided password matches
//            // You can store user information in the session or use Spring Security for authentication
//            return "/home"; // Redirect to the home page after successful login
//        } else {
//            // Invalid credentials
//            return "?error"; // Redirect back to the login page with an error parameter
//        }
//    }

//    @GetMapping("/register")
//    public String showRegisterPage(Model model) {
//        model.addAttribute("user", new User());
//        return "register";
//    }

//    @PostMapping("/register")
//    public String processRegistration(@ModelAttribute("user") User user) {
//        // Implement your registration logic here
//        // You can save the user data to the database
//        // For simplicity, let's assume the registration is successful
//        return "redirect:/USER/login"; // Redirect to the login page after successful registration
//    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping("/new")
    public String showCreateNewUserForm(Model model) {
        List<Role> listRoles = roleRepo.findAll();
        model.addAttribute("listRoles", listRoles);
        model.addAttribute("user", new User());
        return "user_form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userRepo.save(user);
        return "redirect:/USER/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        User user = userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));
        model.addAttribute("user", user);
        List<Role> listRoles = roleRepo.findAll();
        model.addAttribute("listRoles", listRoles);
        return "user_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userRepo.deleteById(id);
        return "redirect:/USER/users";
    }
}
