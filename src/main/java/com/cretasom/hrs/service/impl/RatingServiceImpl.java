package com.cretasom.hrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.cretasom.hrs.entity.Hotel;
import com.cretasom.hrs.entity.Rating;
import com.cretasom.hrs.entity.User;
import com.cretasom.hrs.repo.HotelRepository;
import com.cretasom.hrs.repo.RatingRepository;
import com.cretasom.hrs.repo.UserRepository;

@Service
public class RatingServiceImpl {
	@Autowired
	RatingRepository repo;
	@Autowired
	HotelRepository hotelService;
	@Autowired
	UserRepository userService;

	public Rating addRating(Rating r) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		User user = userService.findByUserName(userName);
		// User user = userService.findById(r.getUserId()).get();
		Hotel hotel = hotelService.findById(r.getHotelId()).get();
		r.setHotel(hotel);
		r.setUser(user);
		return repo.save(r);
	}

	public List<Rating> getAll() {
		return repo.findAll();
	}

}
