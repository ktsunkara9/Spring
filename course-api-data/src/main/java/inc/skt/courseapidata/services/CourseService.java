package inc.skt.courseapidata.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inc.skt.courseapidata.model.Course;
import inc.skt.courseapidata.repositories.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository repository;

	public List<Course> getAllCourses(String topicid) {
		System.out.println(repository.findByTopicId(topicid));
		List<Course> courses = repository.findByTopicId(topicid);
		return courses;
	}

	public Course getCourse(String id) {
		return repository.findById(id).get();
	}

	public void addCourse(Course course) {
		repository.save(course);
	}

	public void updateCourse(Course course) {
		repository.save(course);
	}

	public void deleteCourse(String id) {
		repository.deleteById(id);
	}

}
