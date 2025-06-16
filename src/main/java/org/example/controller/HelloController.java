package org.example.controller;

import java.util.ArrayList;
import java.util.List;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	private final UserService userService;

	@Autowired
	public HelloController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		var users = userService.listUsers();
		users.forEach(it -> messages.add(it.getFirstName()));
		model.addAttribute("messages", messages);
		return "index";
	}
	
}