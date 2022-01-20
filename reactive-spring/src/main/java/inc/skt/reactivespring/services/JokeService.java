package inc.skt.reactivespring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import inc.skt.reactivespring.json.JokeResponse;
import reactor.core.publisher.Mono;

@Service
public class JokeService {

	private static final String BASE = "https://api.icndb.com/jokes/random?limitTo=[nerdy]";

	private RestTemplate restTemplate;

	private WebClient webClient;

	@Autowired
	public JokeService(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
		webClient = WebClient.create("https://api.icndb.com");
	}

	public String getJoke() {
		String url = String.format("%s&firstName=%s&lastName=%s", BASE, "Vishnu", "Manchu");
		JokeResponse response = restTemplate.getForObject(url, JokeResponse.class);
		String joke = "";
		if (response != null)
			joke = response.getValue().getJoke();
		return joke;
	}

	public Mono<String> getJokeAsync(String first, String last) {
		String path = "/jokes/random?limitTo=[nerdy]&firstName={first}&lastName={last}";
		return webClient.get().uri(path, first, last).retrieve().bodyToMono(JokeResponse.class)
				.map(response -> response.getValue().getJoke());
	}

}
