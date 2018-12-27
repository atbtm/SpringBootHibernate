package com.atbtm.SpringBootProject.hello.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.atbtm.SpringBootProject.hello.controllers.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
public class UserControllerTest {
	private MockMvc mvc;
	
	@Before
	public void setup() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}
	
	@Test
	public void testUserController() throws Exception {
		// get empty user list
		RequestBuilder request = get("/users");
		mvc.perform(request).andExpect(status().isOk())
				.andExpect(content().string(equalTo("[]")));
		
		// post a user
		request = post("/users").param("id", "1")
				.param("name", "TestName")
				.param("age", "28");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("success")));
		
		// get user list
		request = get("/users");
		mvc.perform(request).andExpect(status().isOk())
				.andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"TestName\",\"age\":28}]")));
		
		// put 
		request = put("/users/1").param("name", "NewName").param("age", "29");
		mvc.perform(request).andExpect(status().isOk())
			.andExpect(content().string(equalTo("{\"id\":1,\"name\":\"NewName\",\"age\":29}")));
	}

}
