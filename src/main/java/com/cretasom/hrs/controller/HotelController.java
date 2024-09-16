package com.cretasom.hrs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cretasom.hrs.entity.Hotel;
import com.cretasom.hrs.service.HotelService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	HotelService hotelService;

	@GetMapping("/add")
	public String showHotelForm(Hotel hotel, Model model) {
		return "hotel/add";
	}

	@PostMapping("/addhotel")
	public String addHotel(@Valid Hotel hotel, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "hotel/add";
		}
		hotelService.addHotel(hotel);
		return "redirect:/hotel/index";
	}

	@GetMapping({ "/index", "" })
	public String showHotelList(Model model) {
		List<Hotel> hotelList = hotelService.getAllHotel();
		model.addAttribute("hotels", hotelList.isEmpty() ? null : hotelList);
		return "hotel/index";
	}

}