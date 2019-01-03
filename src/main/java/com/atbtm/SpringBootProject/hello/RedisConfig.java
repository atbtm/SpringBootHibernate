package com.atbtm.SpringBootProject.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;

import com.atbtm.SpringBootProject.hello.models.RedisUser;

@Configuration
public class RedisConfig {

	//@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
		
	}
	
	@Bean
	RedisClient getRedisClient() {
		//RedisClient redisClient = RedisClient.create("redis://password@localhost:6379/0");
		return RedisClient.create("redis://localhost:6379/0");
	}
	
	
	@Bean
	public StatefulRedisConnection getStatefulRedisConnection(RedisClient redisClient) {
		StatefulRedisConnection connection = redisClient.connect();
		return connection;
	}
	
	@Bean
	public StringRedisSerializer getStringRedisSerialzer() {
		return new StringRedisSerializer();
	}
	
	@Bean
	public RedisObjectSerializer getRedisObjectSerializer() {
		return new RedisObjectSerializer();
	}
	
	//@Bean
	public RedisTemplate<String, RedisUser> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, RedisUser> template = new RedisTemplate<>();
		template.setConnectionFactory(factory);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new RedisObjectSerializer());
		return template;
	}
}
