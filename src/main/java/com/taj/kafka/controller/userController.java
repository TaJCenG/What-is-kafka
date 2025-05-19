package com.taj.kafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taj.kafka.dto.User;
import com.taj.kafka.service.UserProducerService;

@RestController
@RequestMapping(value="/us")
public class userController {
	
	@Autowired
	private UserProducerService service;

	private final Logger log = LoggerFactory.getLogger(userController.class);
	
	@PostMapping("/post")
	public  User sendUserData(@RequestBody User user) {
		String Message = " Hi I'm in producer service";
		service.sendUserData(user);
		log.info("Message" + Message);
		log.info("User Name is : " + user.getName());
		log.info("User age is : " + user.getAge());
		return user;
	}
}
