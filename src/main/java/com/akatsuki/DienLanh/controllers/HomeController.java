package com.akatsuki.DienLanh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.akatsuki.DienLanh.model.User;
import com.akatsuki.DienLanh.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String Home() {
		return "index";
	}
}
