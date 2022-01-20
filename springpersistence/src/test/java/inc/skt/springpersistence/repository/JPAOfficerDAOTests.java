package inc.skt.springpersistence.repository;

import static inc.skt.springpersistence.entities.Rank.CAPTAIN;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import inc.skt.springpersistence.entities.Officer;

@SpringBootTest
@Transactional
class JPAOfficerDAOTests {

	@Autowired
	private JPAOfficerDAO dao;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private List<Integer> getIds() {
		return jdbcTemplate.query("select id from officers", (rs, rowNum) -> rs.getInt("id"));
	}

	@Test
	void testSave() {
		Officer officer = new Officer(CAPTAIN, "Krishna", "Teja");
		dao.save(officer);
		assertNotNull(officer.getId());
	}

	@Test
	void testfindByIdThatExists() {
		getIds().forEach(id -> {
			Optional<Officer> officer = dao.findById(id);
			assertEquals(officer.get().getId(), id);
			assertTrue(officer.isPresent());
		});
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
		assertEquals(getIds().size(), dao.count());
	}

	@Test
	void testDelete() {
		getIds().forEach(id -> {
			Optional<Officer> officer = dao.findById(id);
			assertTrue(officer.isPresent());
			dao.delete(officer.get());
		});
		assertEquals(0, dao.count());
	}

	@Test
	void testExistsById() {
		getIds().forEach(id -> assertTrue(dao.existsById(id)));
	}

}
