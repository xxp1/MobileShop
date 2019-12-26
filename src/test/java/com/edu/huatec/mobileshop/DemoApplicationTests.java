package com.edu.huatec.mobileshop;

import com.edu.huatec.mobileshop.entity.User;
import com.edu.huatec.mobileshop.service.UserService;
import com.edu.huatec.mobileshop.util.SpringUtils;

import org.junit.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootTest
 class DemoApplicationTests {

	@Test
	void contextLoads() {
		ApplicationContext context = SpringUtils.getApplicationContext();

		UserService userService = (UserService)context.getBean("userService");

		List<User> users = userService.findList();
		System.out.println(users);
	}
}
