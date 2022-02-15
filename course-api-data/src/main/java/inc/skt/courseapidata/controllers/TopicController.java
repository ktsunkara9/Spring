package inc.skt.courseapidata.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import inc.skt.courseapidata.model.Topic;
import inc.skt.courseapidata.services.TopicService;

@RequestMapping("/topicapi")
@RestController
public class TopicController {

	@Autowired
	private TopicService service;

	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
		return service.getAllTopics();
	}

	@GetMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return service.getTopic(id);
	}

	@PostMapping("/topics")
	public void addTopic(@RequestBody Topic topic) {
		service.addTopic(topic);
	}

	@PutMapping("/topics/{id}")
	public void updateTopic(@RequestBody Topic topic) {
		service.updateTopic(topic);
	}

	@DeleteMapping("/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		service.deleteTopic(id);
	}
}
