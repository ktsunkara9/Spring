package inc.skt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import inc.skt.demo.json.Greeting;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public Greeting defaultGreeting() {
		return new Greeting("Welcome, Krishna !");
	}

	@Bean
	public Greeting customGreeting() {
		return new Greeting("Welcome, Sunkara Krishna Teja !");
	}
}
