package inc.skt.springpersistence.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import inc.skt.springpersistence.entities.Officer;
import static inc.skt.springpersistence.entities.Rank.CAPTAIN;


@SpringBootTest
@Transactional
class JDBCOfficerDAOTests {

	@Autowired
	private JDBCOfficerDAO dao;

	@Test
	void testSave() {
		Officer officer = new Officer(CAPTAIN, "Krishna", "Teja");
		officer = dao.save(officer);
		assertNotNull(officer.getId());
	}

	@Test
	void testfindByIdThatExists() {
		Optional<Officer> officer = dao.findById(1);
		assertAll(()->assertTrue(officer.isPresent()), () -> assertEquals(1, officer.get().getId().intValue()));
	}

	@Test
	void testfindByIdThatDoesntExists() {
		Optional<Officer> officer = dao.findById(999);
		assertFalse(officer.isPresent());
	}

	@Test
	void testFindAll() {
		List<String> lastNames = dao.findAll().stream().map(officer -> officer.getLastName())
				.collect(Collectors.toList());
		assertThat(lastNames, containsInAnyOrder("Kirk", "Picard", "Sisko", "Janeway", "Archer"));
	}

	@Test
	void testCount() {
		assertEquals(5, dao.count());
	}

	@Test
	void testDelete() {
		IntStream.rangeClosed(1, 5).forEach(id -> {
			Optional<Officer> officer= dao.findById(id);
			assertTrue(officer.isPresent());
			dao.delete(officer.get());
		});
		assertEquals(0, dao.count());
	}

	@Test
	void testExistsById() {

		IntStream.rangeClosed(1, 5).forEach(id -> {
			assertTrue(dao.existsById(id));
		});
	}

}
