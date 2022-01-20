package inc.skt.demo.services;

import java.time.Duration;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import inc.skt.demo.json.Spaceonauts;

@Service
public class AstroService {

	private RestTemplate restTemplate;
	private WebClient webClient;

	@Autowired
	public AstroService(RestTemplateBuilder restTemplatebuilder, WebClient.Builder wcBuilder) {
		restTemplate = restTemplatebuilder.build();
		webClient = wcBuilder.baseUrl("http://api.open-notify.org").build();
	}

	public Optional<Spaceonauts> getSpacePeople() {
		Spaceonauts peopleInSpace = restTemplate.getForObject("http://api.open-notify.org/astros.json",
				Spaceonauts.class);
		System.out.println(peopleInSpace);
		return Optional.ofNullable(peopleInSpace);
	}

	public Spaceonauts getSpacePeopleAsynchronously() {
		return webClient.get().uri("/astros.json").accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(Spaceonauts.class).block(Duration.ofSeconds(10));
	}

}
