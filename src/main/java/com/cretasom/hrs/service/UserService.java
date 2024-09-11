package com.cretasom.hrs.service;

import java.util.List;

import com.cretasom.hrs.entity.User;

public interface UserService {

	void addUser(User user);

	void updateUser(User user);

	void deleteUser(int id);

	List<User> getAllUser();

	User getUserById(int id);
}
