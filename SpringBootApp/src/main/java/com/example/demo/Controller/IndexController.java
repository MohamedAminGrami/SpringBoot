package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


    @Controller
	@RequestMapping("/")
	public class IndexController {

		
		
		@RequestMapping(value = "/", method = RequestMethod.GET)
		 public String index()
		 {
			return "index";
		 }
		
		@RequestMapping(value = "/users", method = RequestMethod.GET)
		public String viewHomePageUser(Model model)
		{
			
			return"redirect:/USER/users";
		}
		
		@RequestMapping(value = "/roles", method = RequestMethod.GET)
		public String viewHomePageRole(Model model)
		{
			
			return"redirect:/ROLE/roles";
		}
		
		
		
}
