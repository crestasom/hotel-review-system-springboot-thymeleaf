package com.cretasom.hrs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cretasom.hrs.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {

	List<User> userList = new ArrayList<>();

	int id = 1;

	@GetMapping("/")
	public String index(Model model) {
		for (User user : userList) {

		}
		model.addAttribute("users", userList);
		return "user/index";
	}

	@GetMapping("/add")
	public String showAddForm(User user) {
		return "user/add";
	}

	@PostMapping("/adduser")
	public String addUser(User user) {
		user.setId(id);
		id++;
		userList.add(user);
		// System.out.println(user.getName() + " " + user.getEmail());
		return "redirect:/user/";
	}
}
