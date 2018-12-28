package com.atbtm.SpringBootProject.hello.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data(staticConstructor="of")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private final String name;
	
	@Column(nullable = false)
	private final Integer age;
}
