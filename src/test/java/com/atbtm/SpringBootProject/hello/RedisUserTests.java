package com.atbtm.SpringBootProject.hello;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atbtm.SpringBootProject.hello.models.RedisUser;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisUserTests {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private StatefulRedisConnection<String, String> statefulRedisConnection;
	
	@Autowired
	private RedisObjectSerializer redisObjectSerializer;
	
	@Autowired
	private StringRedisSerializer stringRedisSerializer;
	
	@Test
	public void test() {
		this.stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}
	
	@Test
	public void testRedisTemplate() {
		RedisUser redisUser = new RedisUser("Shanpeng", 28);
		RedisCommands<String, String> syncCommands = this.statefulRedisConnection.sync();

		syncCommands.set(redisUser.getUsername(), new StringRedisSerializer().deserialize(redisObjectSerializer.serialize(redisUser)));
		
		redisUser = new RedisUser("蝙蝠侠", 30);
		syncCommands.set(redisUser.getUsername(), new StringRedisSerializer().deserialize(redisObjectSerializer.serialize(redisUser)));

		redisUser = new RedisUser("蜘蛛侠", 40);
		syncCommands.set(redisUser.getUsername(), new StringRedisSerializer().deserialize(redisObjectSerializer.serialize(redisUser)));
//System.out.println(syncCommands.get("超人"));
		//Assert.assertEquals(20, ((RedisUser) redisObjectSerializer.deserialize(stringRedisSerializer.serialize(syncCommands.get("超人")))).getAge().longValue());
		Assert.assertEquals(30, ((RedisUser) redisObjectSerializer.deserialize(stringRedisSerializer.serialize(syncCommands.get("蝙蝠侠")))).getAge().longValue());
		Assert.assertEquals(40, ((RedisUser) redisObjectSerializer.deserialize(stringRedisSerializer.serialize(syncCommands.get("蜘蛛侠")))).getAge().longValue());

	}
}
