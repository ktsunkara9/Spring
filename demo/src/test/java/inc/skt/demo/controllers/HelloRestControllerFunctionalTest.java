package inc.skt.demo.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import inc.skt.demo.json.Greeting;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloRestControllerFunctionalTest {

	@Test
	void greetWithName(@Autowired TestRestTemplate template) //In JUnit 5 we can pass arguments to test methods and auto-wire the dependencies
	{ 
		Greeting response = template.getForObject("/rest?name=Krishna", Greeting.class);
		assertEquals("Hello Krishna !", response.getMessage());

	}

	@Test
	void greetWithoutName(@Autowired TestRestTemplate template) {
		ResponseEntity<Greeting> responseEntity = template.getForEntity("/rest", Greeting.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
		Greeting response = responseEntity.getBody();
		if (response != null)
			assertEquals("Hello World !", response.getMessage());
	}
}
