package inc.skt.demo.controllers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;

class HelloControllerUnitTest {

	//This is not a Pure Unit Test as Spring is involved
	@Test
	void sayHello() {
		HelloController controller = new HelloController();
		Model model = new BindingAwareModelMap();
		String result = controller.sayHello("Krishna", model);
		assertAll(
			() -> assertEquals("hello", result),
			() -> assertEquals("Krishna", model.getAttribute("user"))
		);
	}
	
	//Pure Unit Test
	@Test
	void sayHelloWithStub() {
		HelloController controller = new HelloController();
		Model model = mock(Model.class);
		String name = "Krishna";
		when(model.addAttribute(anyString(), any())).thenReturn(model);
		
		String result = controller.sayHello(name, model);
		assertEquals("hello", result);
	}

}
