package com.akatsuki.DienLanh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.util.collections.ConcurrentReferenceHashMap.Option;
import org.springframework.beans.factory.annotation.Autowired;

import com.akatsuki.DienLanh.model.User;
import com.akatsuki.DienLanh.repositories.UserRepository;

public interface UserService {
	
    User findById(Long id);
 
    void saveUser(User user);
 
    void updateUser(User user);
 
    void deleteUserById(Long id);
 
    void deleteAllUsers();
 
    List<User> findAllUsers();
 
    boolean isUserExist(User user);

}
