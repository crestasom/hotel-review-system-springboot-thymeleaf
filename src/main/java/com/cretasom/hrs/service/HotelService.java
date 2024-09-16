package com.cretasom.hrs.service;

import java.util.List;

import com.cretasom.hrs.entity.Hotel;

public interface HotelService {

	Hotel addHotel(Hotel hotel);

	List<Hotel> getAllHotel();
}
