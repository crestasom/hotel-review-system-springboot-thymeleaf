package com.cretasom.hrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cretasom.hrs.entity.Hotel;
import com.cretasom.hrs.repo.HotelRepository;
import com.cretasom.hrs.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	HotelRepository hotelRepo;

	@Override
	public Hotel addHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		hotelRepo.save(hotel);
		return hotel;
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return hotelRepo.findAll();
	}

}
