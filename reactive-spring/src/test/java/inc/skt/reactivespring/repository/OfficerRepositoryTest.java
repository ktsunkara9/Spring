package inc.skt.reactivespring.repository;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import inc.skt.reactivespring.OfficerRepository;
import inc.skt.reactivespring.entities.Officer;
import inc.skt.reactivespring.entities.Rank;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class OfficerRepositoryTest {

	@Autowired
	private OfficerRepository dao;

	private List<Officer> officers = List.of(new Officer(Rank.CAPTAIN, "James", "Kirk"),
			new Officer(Rank.CAPTAIN, "Jean-Luc", "Picard"), new Officer(Rank.CAPTAIN, "Benjamin", "Sisko"),
			new Officer(Rank.CAPTAIN, "Kathryn", "Janeway"), new Officer(Rank.CAPTAIN, "Jonathan", "Archer"));

	@BeforeTestClass
	public void setUp() {
		dao.deleteAll().thenMany(Flux.fromIterable(officers)).flatMap(dao::save).then().block();
	}

	@Test
	void testSave() {
		Officer officer = new Officer(Rank.CAPTAIN, "Krishna", "Teja");
		StepVerifier.create(dao.save(officer)).expectNextMatches(o -> o.getId() != null).verifyComplete();
	}

	@Test
	void findAll() {
		StepVerifier.create(dao.findAll()).expectNextCount(5).verifyComplete();
	}

	@Test
	void findById() {
		officers.stream().map(Officer::getId)
				.forEach(id -> StepVerifier.create(dao.findById(id)).expectNextCount(1).verifyComplete());
	}
	
	@Test
	void findByIdNotExist() {
		StepVerifier.create(dao.findById("999")).verifyComplete();
	}
	
	@Test
	void count() {
		StepVerifier.create(dao.count()).expectNext(5L).verifyComplete();
	}
	
	@Test
	void findByRank() {
		
	}
}
