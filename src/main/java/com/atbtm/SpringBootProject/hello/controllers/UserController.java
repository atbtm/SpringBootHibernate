package com.atbtm.SpringBootProject.hello.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atbtm.SpringBootProject.hello.models.User;

@RestController
@RequestMapping(value="/users")
public class UserController {
	static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

	@RequestMapping("/hello")
	public String hello() {
		return "Hello!";
	}
	
	@GetMapping
	public List<User> getUsers() {
		List<User> userList = new ArrayList<>(users.values());
		return userList;
	}

    @PostMapping
	public String postUser(@ModelAttribute User user) {
		users.put(user.getId(), user);
		return "success";
	}

    @RequestMapping(value="/{id}", method=RequestMethod.GET) 
	public User getUser(@PathVariable Long id) {
		return users.get(id);
	}

    @RequestMapping(value="/{id}", method=RequestMethod.PUT) 
	public User putUser(@PathVariable Long id, @ModelAttribute User user) {
		User u = users.get(id);
		//u.setName(user.getName());
		u.setId(user.getId());
		//u.setAge(user.getAge());
		users.put(id, u);
		return u;
	}

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE) 
	public String deleteUser(@PathVariable Long id) {
		users.remove(id);
		return "success";
	}
}









