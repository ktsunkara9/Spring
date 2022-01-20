package inc.skt.demo.services;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import inc.skt.demo.json.Spaceonauts;

@SpringBootTest
class AstroServiceTest {

	@Autowired
	private AstroService astroService;

	@Test
	void test() {
		Optional<Spaceonauts> result = astroService.getSpacePeople();
		Spaceonauts spacePeople = result.get();
		System.out.println(spacePeople);
		assertAll(() -> assertNotNull(spacePeople), () -> assertTrue(spacePeople.getNumber() >= 0),
				() -> assertEquals(spacePeople.getPeople().size(), spacePeople.getNumber()),
				() -> assertNotNull(spacePeople.getMessage()));
	}

	@Test
	void testGetSpacePeopleAsynchronously() {
		Spaceonauts result = astroService.getSpacePeopleAsynchronously();
		System.out.println(result);
		assertAll(() -> assertNotNull(result), () -> assertTrue(result.getNumber() >= 0),
				() -> assertEquals(result.getPeople().size(), result.getNumber()),
				() -> assertNotNull(result.getMessage()));
	}

}
