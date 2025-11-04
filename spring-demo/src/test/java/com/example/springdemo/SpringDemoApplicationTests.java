package com.example.springdemo;

import com.example.springdemo.json.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootTest
class SpringDemoApplicationTests {

	@Autowired
	private ApplicationContext ctxt;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(ctxt);
		System.out.println(ctxt.getBeanDefinitionCount());
		Arrays.stream(ctxt.getBeanDefinitionNames()).forEach(System.out::println);
	}

	@Test
	public void getMessageTwice() {
		Message msg1 = ctxt.getBean("defaultGreeting", Message.class);
		Message msg2 = ctxt.getBean("defaultGreeting", Message.class);
		Assertions.assertSame(msg1, msg2);
		System.out.println(msg1);
	}

}
