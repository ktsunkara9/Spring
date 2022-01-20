package inc.skt.reactivespring.services;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import inc.skt.reactivespring.json.JokeResponse;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class JokeServiceIntegrationTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private JokeService jokeService;

	@Test
	void test() {
		ResponseEntity<JokeResponse> responseEntity = testRestTemplate.getForEntity(
				"https://api.icndb.com/jokes/random?limitTo=[nerdy]", JokeResponse.class);

		assertAll(() -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
				() -> assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType()),
				() -> assertThat(responseEntity.getBody().getValue().getJoke(), containsString("Norris")));

	}
	
	@Test
	void testGetJokeAsync() {
		String joke = jokeService.getJokeAsync("Vishnu", "Manchu").block(Duration.ofSeconds(10));
		System.out.println(joke);
		assertTrue(joke.contains("Vishnu"));
	}
	
	@Test
	void testGetJokeAsyncWithStepVeryfier() {
		StepVerifier.create(jokeService.getJokeAsync("Vishnu", "Manchu")).assertNext(joke -> {
			System.out.println(joke);
			assertTrue(joke.contains("Vishnu"));
		}).verifyComplete();
	}

}
