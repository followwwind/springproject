package com.wind.service;

import com.wind.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@Test
	public void testInsert() {
		User user = new User();
		user.setUserId("1510825164758");
		user.setUsername("follow");
		user.setPassword("123");
		user.setEmail("18771933975@163.com");
		user.setTime(new Date());
		user.setAge(18);
		userService.insert(user);
	}

	@Test
	public void testSelectByPrimaryKey() {
		User user = userService.selectByPrimaryKey("1510825164756");
		System.out.println("==========================================");
		if(user != null){
			System.out.println(user.getUsername() + "," + user.getAge());
		}
	}

	@Test
	public void testSelectByCondition() {
		User user = new User();
		user.setUsername("wind");
		List<User> users = userService.selectByCondition(user);
		System.out.println(users.size());
	}

	@Test
	public void testDeleteByPrimaryKey() {
		userService.deleteByPrimaryKey("1510821374853");
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		User user = new User();
		user.setUserId("1510825164757");
		user.setAge(21);
		userService.updateByPrimaryKeySelective(user);
	}

	@Test
	public void testCountByCondition() {
		User user = new User();
		int count = userService.countByCondition(user);
		System.out.println(count);
	}

}
