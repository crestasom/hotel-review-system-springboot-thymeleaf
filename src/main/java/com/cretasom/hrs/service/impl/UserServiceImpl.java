package com.cretasom.hrs.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cretasom.hrs.entity.User;
import com.cretasom.hrs.repo.UserRepository;
import com.cretasom.hrs.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private PasswordEncoder passwordEncoder;

	private Logger logger = LoggerFactory.getLogger(getClass());

	public UserServiceImpl() {
		logger.info("UserServiceImpl created ");
	}

	@Autowired
	private UserRepository userRepo;

	@Override
	public User addUser(User user) {
		System.out.println("encoding user password");
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		System.out.println("encoding user password done");
		return userRepo.save(user);
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
