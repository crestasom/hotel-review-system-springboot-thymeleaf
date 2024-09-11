package com.cretasom.hrs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cretasom.hrs.entity.User;
import com.cretasom.hrs.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	public UserServiceImpl() {
		System.out.println("UserServiceImpl created");
	}

	List<User> userList = new ArrayList<>();

	int id = 1;

	@Override
	public void addUser(User user) {

		user.setId(id);
		id++;
		userList.add(user);

	}

	@Override
	public void updateUser(User user) {
		User user1 = userList.get(user.getId() - 1);
		user1.setName(user.getName());

	}

	@Override
	public void deleteUser(int id) {
		userList.remove(id - 1);

	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userList;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userList.get(id - 1);
	}

}
