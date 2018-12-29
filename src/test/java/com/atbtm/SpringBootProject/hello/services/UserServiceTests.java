package com.atbtm.SpringBootProject.hello.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atbtm.SpringBootProject.hello.Application;

import lombok.extern.java.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
//@WebAppConfiguration
@Log
public class UserServiceTests {
	@Autowired
	private UserService userService;
	
	@Before
	public void setup() {
		userService.createUserTable();
		userService.deleteAllUsers();
	}
	
	@Test
	public void test() throws Exception {
		userService.create("a", 1);
		userService.create("b", 2);
		userService.create("c", 3);
		userService.create("d", 4);
		userService.create("e", 5);
		
		Assert.assertEquals(5, userService.getAllUsers().intValue());
		log.warning("################## "+userService.getAllUsers());
	}
}
