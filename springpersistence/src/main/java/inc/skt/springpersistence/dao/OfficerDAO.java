package inc.skt.springpersistence.dao;

import java.util.List;
import java.util.Optional;

import inc.skt.springpersistence.entities.Officer;

public interface OfficerDAO {

	public abstract Officer save(Officer officer);

	public abstract Optional<Officer> findById(Integer id);

	public abstract List<Officer> findAll();

	public abstract long count();

	public abstract void delete(Officer officer);

	public abstract boolean existsById(Integer id);

}
