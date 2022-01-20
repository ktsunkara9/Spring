package inc.skt.springpersistence.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import inc.skt.springpersistence.dao.OfficerDAO;
import inc.skt.springpersistence.entities.Officer;
import inc.skt.springpersistence.entities.Rank;

@Repository
public class JDBCOfficerDAO implements OfficerDAO {

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert simpleJdbcInsert;

	@Autowired
	public JDBCOfficerDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("officers")
				.usingGeneratedKeyColumns("id");
	}

	@Override
	public Officer save(Officer officer) {
		Map<String, Object> map = new HashMap<>();
		map.put("rank", officer.getRank());
		map.put("first_name", officer.getFirstName());
		map.put("last_name", officer.getLastName());
		Integer id = (Integer) simpleJdbcInsert.executeAndReturnKey(map);
		officer.setId(id);
		return officer;
	}

	@Override
	public Optional<Officer> findById(Integer id) {
		if (!existsById(id))
			return Optional.empty();

		Officer officer = jdbcTemplate.queryForObject("select * from officers where id = ?", new RowMapper<Officer>() {
			@Override
			public Officer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Officer(rs.getInt("id"), Rank.valueOf(rs.getString("rank")), rs.getString("first_name"),
						rs.getString("last_name"));
			}

		}, id);

		return Optional.of(officer);
	}

	@Override
	public List<Officer> findAll() {
		return jdbcTemplate.query("select * from officers", (rs, rowNum) -> {
			return new Officer(rs.getInt("id"), Rank.valueOf(rs.getString("rank")), rs.getString("first_name"),
					rs.getString("last_name"));
		});
	}

	@Override
	public long count() {
		return jdbcTemplate.queryForObject("select count(*) from officers", Long.class);
	}

	@Override
	public void delete(Officer officer) {
		int id = officer.getId();
		jdbcTemplate.update("delete from Officers where id = ?", id);
	}

	@Override
	public boolean existsById(Integer id) {
		return jdbcTemplate.queryForObject("select exists(select 1 from officers where id = ?)", Boolean.class, id);
	}

}
