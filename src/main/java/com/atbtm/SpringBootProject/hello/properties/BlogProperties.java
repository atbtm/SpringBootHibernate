package com.atbtm.SpringBootProject.hello.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
//import lombok.Data;
import lombok.Getter;

@Component
@Data
public class BlogProperties {
	@Value("${com.atbtm.blog.name}")
	@Getter(AccessLevel.PUBLIC)
	private String name;
	
	@Value("${com.atbtm.blog.title}")
	@Getter(AccessLevel.PUBLIC)
	private String title;
}
