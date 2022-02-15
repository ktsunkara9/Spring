package inc.skt.courseapidata.repositories;

import org.springframework.data.repository.CrudRepository;

import inc.skt.courseapidata.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
