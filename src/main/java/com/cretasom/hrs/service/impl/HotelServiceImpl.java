package com.cretasom.hrs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cretasom.hrs.entity.Hotel;
import com.cretasom.hrs.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	List<Hotel> hotelList = new ArrayList<>();
	int id = 1;

	@Override
	public Hotel addHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		hotel.setId(id);
		id++;
		hotelList.add(hotel);
		return hotel;
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return hotelList;
	}

}
