package com.cretasom.hrs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cretasom.hrs.entity.User;
import com.cretasom.hrs.service.impl.UserServiceImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserServiceImpl userService;

	public UserController() {
		System.out.println("UserController created");
	}

	@GetMapping({ "/", "/index" })
	public String index(Model model) {

		model.addAttribute("users", userService.getAllUser());
		return "user/index";
	}

	@GetMapping("/add")
	public String showAddForm(User user) {
		return "user/add";
	}

	@PostMapping("/adduser")
	public String addUser(@RequestParam(name = "image") MultipartFile file, @Valid User user,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "user/add";
		}
		userService.addUser(user);
		// System.out.println(user.getName() + " " + user.getEmail());
		return "redirect:/user/";
	}

	@GetMapping("/edit/{id}")
	public String showAddForm(@PathVariable int id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "user/update";
	}

	@PostMapping("/updateuser")
	public String updateUser(User user) {
		userService.updateUser(user);
		// System.out.println(user.getName() + " " + user.getEmail());
		return "redirect:/user/";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id, Model model) {
		userService.deleteUser(id);
		model.addAttribute("users", userService.getAllUser());
		return "redirect:/user/";
	}
}
