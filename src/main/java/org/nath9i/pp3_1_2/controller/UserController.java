package org.nath9i.pp3_1_2.controller;

import jakarta.validation.Valid;

import org.nath9i.pp3_1_2.model.User;
import org.nath9i.pp3_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	private UserService userService;

	@Autowired
	private UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String showAllUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "all-users";
	}

	@GetMapping(value = "/addNewUser")
	public String addNewUser(Model model) {
		model.addAttribute("user", new User());
		return "user";
	}

	@PostMapping(value = "/saveUser")
	public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult
	 bindingResult) {
		if (bindingResult.hasErrors()) {
			return "user";
		}
		userService.createOrUpdateUser(user);
		return "redirect:/";
	}

	@GetMapping(value = "/updateUser")
	public String updateUser(@RequestParam("id") int id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "user";
	}

	@PostMapping(value = "/deleteUser")
	public String deleteUser(@RequestParam("id") int id) {
		userService.deleteUser(id);
		return "redirect:/";
	}
}