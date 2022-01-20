package inc.skt.reactivespring;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import inc.skt.reactivespring.entities.Officer;
import inc.skt.reactivespring.entities.Rank;
import reactor.core.publisher.Flux;

public interface OfficerRepository extends ReactiveMongoRepository<Officer, String> {

	public abstract Flux<Officer> findByRank(Rank rank);

	public abstract Flux<Officer> findByLast(String last);

}
