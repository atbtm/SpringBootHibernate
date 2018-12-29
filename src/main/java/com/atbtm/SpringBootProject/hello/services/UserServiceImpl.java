package com.atbtm.SpringBootProject.hello.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public void create(String name, Integer age) {
		jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", name, age);
	}

	@Override
	public void deleteByName(String name) {
		this.jdbcTemplate.update("delete from USER where name = ?", name);
	}

	@Override
	public Integer getAllUsers() {
		return this.jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
	}

	@Override
	public void createUserTable() {
		this.jdbcTemplate.update("create table USER(name varchar(30), age int(10))");
	}

	@Override
	public void deleteAllUsers() {
		this.jdbcTemplate.update("delete from USER");
	}

}
