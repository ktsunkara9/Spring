package inc.skt.reactivespring.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JokeServiceUnitTest {

	@Autowired
	private JokeService jokeService;
	
	@Test
	void test() {
		String joke = jokeService.getJoke();
		System.out.println(joke);
		assertNotNull(joke);
	}

}
