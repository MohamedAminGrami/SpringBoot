package com.example.demo.Controller;


import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.Entity.Role;
// import com.example.demo.Entity.User;
import com.example.demo.Repository.RoleRepository;
// import com.example.demo.Repository.UserRepository;
@Controller
@RequestMapping("/ROLE")
public class RoleController {
	//    @Autowired
	//    private UserRepository userRepo;
	   @Autowired
	   private RoleRepository roleRepo;
	   @GetMapping("/roles")
	   public String showRoleList(Model model) {
		    List<Role> listRoles = roleRepo.findAll();
		    model.addAttribute("listRoles", listRoles);
		    return "role";
	   }
	   
	  	   
	   @GetMapping("/roles/new")
	   public String showCreateNewUserForm(Model model) {
		      
		    model.addAttribute("role", new Role());
		    return "role_form";
	   }
	   
	   
	   @PostMapping("/roles/save")
	   public String saveRole(Role role) {
		   roleRepo.save(role);
		   return"redirect:/roles";
		   
	   }
	   
	   
	   @GetMapping("/roles/modifier/{id}")
	   public String showEditForm(@PathVariable("id") Integer id, Model model) {
		  Role role = roleRepo.findById(id).get();
		  model.addAttribute("role",role);
		  	  
		   return"role_form";
	   }
	   
	   @GetMapping("/roles/supprimer/{id}")
	   public String deleteUser(@PathVariable("id") Integer id, Model model) {
		  roleRepo.deleteById(id);
		
		   return"redirect:/roles";
	   }
	   


}