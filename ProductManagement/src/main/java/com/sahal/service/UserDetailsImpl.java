package com.sahal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahal.model.UserInfo;
import com.sahal.model.Users;
import com.sahal.repository.UserRepo;
import com.sahal.repository.UseraddRepo;
@Service
public class UserDetailsImpl implements UserDetails {

	
	@Autowired
	private UseraddRepo userAddRepo;
	@Override
	public UserInfo addUser(UserInfo user) {
		
		return userAddRepo.save(user);
	}

}
