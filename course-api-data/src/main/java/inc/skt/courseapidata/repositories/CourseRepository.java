package inc.skt.courseapidata.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import inc.skt.courseapidata.model.Course;

public interface CourseRepository extends CrudRepository<Course, String> {
	List<Course> findByTopicId(String topicId);
}
