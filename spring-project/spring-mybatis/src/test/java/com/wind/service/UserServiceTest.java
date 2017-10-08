package com.wind.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wind.entity.User;
import com.wind.util.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@Test
	public void testAddUser() {	
		User user = new User();
		user.setId(String.valueOf(StringUtils.getPKNum()));
		user.setUserName("followwwind");
		user.setPassword("123");
		user.setEmail("18771933975@163.com");
		userService.addUser(user);
	}

	@Test
	public void testFindUserByCondition() {
		Map<String, String> map = new HashMap<>();
		List<User> users = userService.findUserByCondition(map);
		System.out.println(users.size());
	}

	@Test
	public void updateUser() {	
		User user = new User();
		user.setId("1495029521517");
		user.setEmail("970720206@qq.com");
		userService.updateUser(user);
	}

	@Test
	public void deleteUser() {
		String id = "";
		userService.deleteUser(id);
	}
}
