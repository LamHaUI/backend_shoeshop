package com.thungashoe.store.service;


import java.util.List;

import com.thungashoe.store.domain.User;

public interface UserService {
	List<User> getAllUser();

	User findById(Long id);
	
	User findByUsername(String username);
		
	User findByEmail(String email);
		
	void save(User user);
	
	User createUser(String username, String email,  String password, List<String> roles);

}
