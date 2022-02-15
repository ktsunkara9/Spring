package inc.skt.courseapi.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import inc.skt.courseapi.model.Topic;

@Service
public class TopicService {

	List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("Java", "Core Java", "Core Java"),
			new Topic("Spring", "SpringBoot", "Spring Boot"), new Topic("AWS", "AWS", "Amazon Web Services"),
			new Topic("Angular", "Angular", "Javascript Framework")));

	public List<Topic> getAllTopics() {

		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			if (topics.get(i).getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(topic -> topic.getId().equals(id));
	}

}
