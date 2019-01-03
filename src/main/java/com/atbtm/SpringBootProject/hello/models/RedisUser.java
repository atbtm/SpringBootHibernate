package com.atbtm.SpringBootProject.hello.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class RedisUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 103386193817960013L;
	
	private String username;
	private Integer age;
	
	public RedisUser(String username, Integer age) {
		this.username = username;
		this.age = age;
	}
	
	

}
