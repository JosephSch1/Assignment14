package com.coderscampus.assignment14.repository;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.coderscampus.assignment14.dto.User;

@Component
public class UserRepository {
private Set<User> users = new LinkedHashSet<>();
	
	public User save (User user) {
		if (users.size() == 0) {
			user.setId(1L);
		} else {
			user.setId(users.size() + 1L);
		}
		users.add(user);
		return user;
	}
}

