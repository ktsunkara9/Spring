package inc.skt.courseapidata.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inc.skt.courseapidata.model.Topic;
import inc.skt.courseapidata.repositories.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository repository;

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		repository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopic(String id) {
		return repository.findById(id).get();
	}

	public void addTopic(Topic topic) {
		repository.save(topic);
	}

	public void updateTopic(Topic topic) {
		repository.save(topic);
	}

	public void deleteTopic(String id) {
		repository.deleteById(id);
	}

}
