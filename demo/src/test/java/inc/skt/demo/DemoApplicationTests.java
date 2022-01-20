package inc.skt.demo;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import inc.skt.demo.json.Greeting;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	ApplicationContext ctxt;
	
	@Test
	void contextLoads() {
		System.out.println(ctxt.getBeanDefinitionCount());
		Arrays.stream(ctxt.getBeanDefinitionNames()).forEach(System.out::println);
		Greeting greeting1 = ctxt.getBean("defaultGreeting",Greeting.class);
		System.out.println(greeting1);
		
		Greeting greeting2 = ctxt.getBean("customGreeting",Greeting.class);
		System.out.println(greeting2);
	}

}
