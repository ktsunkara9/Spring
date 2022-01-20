package inc.skt.springpersistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import inc.skt.springpersistence.entities.Officer;
import inc.skt.springpersistence.entities.Rank;

public interface OfficerRepository extends JpaRepository<Officer, Integer> {

	List<Officer> findAllByRankAndLastNameContaining(Rank rank, String subString);
}
