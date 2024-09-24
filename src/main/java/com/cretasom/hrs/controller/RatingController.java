package com.cretasom.hrs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cretasom.hrs.entity.Rating;
import com.cretasom.hrs.service.HotelService;
import com.cretasom.hrs.service.UserService;
import com.cretasom.hrs.service.impl.RatingServiceImpl;

@Controller
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	HotelService hotelService;
	@Autowired
	UserService userService;

	@Autowired
	RatingServiceImpl ratingServiceImpl;

	@GetMapping("/add")
	public String showForm(Model model, Rating rating) {
		model.addAttribute("hotels", hotelService.getAllHotel());
		model.addAttribute("users", userService.getAllUser());
		return "rating/add";

	}

	@PostMapping("/addrating")
	public String addRating(Rating rating) {
		// TODO: process POST request
		ratingServiceImpl.addRating(rating);
		return "redirect:/rating/index";
	}

	@GetMapping({ "/index", "", "/" })
	public String showRatingList(Model model) {
		List<Rating> ratings = ratingServiceImpl.getAll();
		model.addAttribute("ratings", ratings.isEmpty() ? null : ratings);
		return "rating/index";
	}

}
