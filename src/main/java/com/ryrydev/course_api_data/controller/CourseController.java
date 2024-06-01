package com.ryrydev.course_api_data.controller;

import com.ryrydev.course_api_data.entity.Course;
import com.ryrydev.course_api_data.entity.Topic;
import com.ryrydev.course_api_data.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics/{topicId}/courses")
public class CourseController {

  @Autowired
  private CourseService courseService;

  @GetMapping
  public List<Course> getAllCourses(@PathVariable String topicId) {
    return courseService.getAllCourses(topicId);
  }

  @GetMapping("/{id}")
  public Course getCourse(@PathVariable String id) {
    return courseService.getCourse(id);
  }

  @PostMapping
  public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
    course.setTopic(new Topic(topicId, "", "")); // Set the topic for the course
    courseService.addCourse(course);
  }

  @PutMapping("/{id}")
  public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
    course.setTopic(new Topic(topicId, "", "")); // Set the topic for the course
    courseService.updateCourse(id, course);
  }

  @DeleteMapping("/{id}")
  public void deleteCourse(@PathVariable String id) {
    courseService.deleteCourse(id);
  }
}
