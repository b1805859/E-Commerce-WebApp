package com.akatsuki.DienLanh.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akatsuki.DienLanh.model.User;
import com.akatsuki.DienLanh.repositories.UserRepository;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	

	@SuppressWarnings("deprecation")
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}


	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}


	public void updateUser(User user) {
		// TODO Auto-generated method stub
		saveUser(user);
	}

	public void deleteUserById(Long id) {
		userRepository.deleteById(id);;
	}

	public void deleteAllUsers() {
		userRepository.deleteAll();
		
	}

	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
