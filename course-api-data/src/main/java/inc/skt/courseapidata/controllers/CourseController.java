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

import inc.skt.courseapidata.model.Course;
import inc.skt.courseapidata.model.Topic;
import inc.skt.courseapidata.services.CourseService;
import inc.skt.courseapidata.services.TopicService;

@RequestMapping("/courseapi")
@RestController
public class CourseController {

	@Autowired
	private CourseService service;

	@GetMapping("/topics/{topicid}/courses")
	public List<Course> getAllCourses(@PathVariable String topicid) {
		return service.getAllCourses(topicid);
	}

	@GetMapping("/topics/{topicid}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return service.getCourse(id);
	}

	@PostMapping("/topics/{topicid}/courses")
	public void addCourse(@PathVariable String topicid, @RequestBody Course course) {

		course.setTopic(new Topic(topicid, "", ""));
		service.addCourse(course);
	}

	@PutMapping("/topics/{topicid}/courses/{id}")
	public void updateCourse(@PathVariable String topicid, @PathVariable String id, @RequestBody Course course) {
		course.setTopic(new Topic(topicid,"",""));
		service.updateCourse(course);
	}

	@DeleteMapping("/topics/{topicid}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		service.deleteCourse(id);
	}
}
