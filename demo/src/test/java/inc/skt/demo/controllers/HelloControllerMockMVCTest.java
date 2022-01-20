package inc.skt.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
class HelloControllerMockMVCTest {
	
	@Autowired
	private MockMvc mvc;

	@Test
	void testHelloWithoutName() throws Exception {
		mvc.perform(get("/hello").accept(MediaType.TEXT_HTML))
		.andExpect(status().isOk())
		.andExpect(view().name("hello"))
		.andExpect(model().attribute("user", "World"));
		
	}
	
	@Test
	void testHelloWithName() throws Exception{
		mvc.perform(get("/hello").param("name", "Krishna")
			.accept(MediaType.TEXT_HTML))
			.andExpect(status().isOk())
			.andExpect(view().name("hello"))
			.andExpect(model().attribute("user", "Krishna"));
	}

}
