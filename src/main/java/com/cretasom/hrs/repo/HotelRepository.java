package com.cretasom.hrs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cretasom.hrs.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
