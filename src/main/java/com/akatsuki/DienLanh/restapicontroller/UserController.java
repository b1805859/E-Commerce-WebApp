package com.akatsuki.DienLanh.restapicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akatsuki.DienLanh.model.User;
import com.akatsuki.DienLanh.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;
	
	//Get all users
	@RequestMapping(value = "/", method = RequestMethod.GET)
	 public ResponseEntity<List<User>> listAllUsers(){
		 List<User> users = userService.findAllUsers();
		 if(users.isEmpty()) {
			 return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		 }
		 return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	 }
	 
	
	 //Get user
	 @SuppressWarnings("unchecked")
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 public ResponseEntity<User> getUser(@PathVariable("id") long id){
		 User user = userService.findById(id);
		 if(user == null ) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<User>(user, HttpStatus.OK);
	 }
	 
	 
	 //Create user
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 @RequestMapping(value = "/", method = RequestMethod.POST)
	 public ResponseEntity<User> createUser(@RequestBody User user){
		 if(userService.isUserExist(user)) {
			 return new ResponseEntity(HttpStatus.CONFLICT);
		 }
		 userService.saveUser(user);

		 return new ResponseEntity<User>(user, HttpStatus.CREATED);
	 }
	 
	 
	 //Update user
	 @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	 public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
		User currentUser = userService.findById(id);
		
		if(currentUser == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setEmail(user.getEmail());
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	 }
	 
	 //Delete user
	 @RequestMapping(value = "/", method = RequestMethod.DELETE)
	 public ResponseEntity<User> deleteUser(@PathVariable long id){
		 User user = userService.findById(id);
		 if(user == null) {
			 return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	 }
	 
	 
	 
	 
	 
}
