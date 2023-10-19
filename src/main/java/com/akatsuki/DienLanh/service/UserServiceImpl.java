package com.akatsuki.DienLanh.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akatsuki.DienLanh.model.User;
import com.akatsuki.DienLanh.repositories.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@SuppressWarnings("deprecation")
	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.getById(id);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		saveUser(user);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);;
	}

	@Override
	public void deleteAllUsers() {
		userRepository.deleteAll();
		
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
