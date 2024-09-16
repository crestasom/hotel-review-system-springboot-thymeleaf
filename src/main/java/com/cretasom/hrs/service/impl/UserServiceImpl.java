package com.cretasom.hrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cretasom.hrs.entity.User;
import com.cretasom.hrs.repo.UserRepository;
import com.cretasom.hrs.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	public UserServiceImpl() {
		System.out.println("UserServiceImpl created");
	}

	@Autowired
	private UserRepository userRepo;

	@Override
	public void addUser(User user) {
		userRepo.save(user);
	}

	@Override
	public void updateUser(User user) {
		userRepo.save(user);

	}

	@Override
	public void deleteUser(int id) {
		userRepo.deleteById(id);

	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).get();
	}

}
