package com.atbtm.SpringBootProject.hello.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	@Getter@Setter
	private String name;
	
	@Column(nullable = false)
	@Getter@Setter
	private Integer age;
	
	public User(String name, Integer age) {
		this.setName(name);
		this.setAge(age);
	}
}
