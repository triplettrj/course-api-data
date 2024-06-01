package com.ryrydev.course_api_data.service;

import com.ryrydev.course_api_data.entity.Course;
import com.ryrydev.course_api_data.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

  @Autowired
  private CourseRepository courseRepository;

  public List<Course> getAllCourses(String topicId) {
    return courseRepository.findByTopicId(topicId);
  }

  public Course getCourse(String id) {
    return courseRepository.findById(id).orElse(null);
  }

  public void addCourse(Course course) {
    courseRepository.save(course);
  }

  public void updateCourse(String id, Course course) {
    course.setId(id); // Ensure the ID is set for the update
    courseRepository.save(course);
  }

  public void deleteCourse(String id) {
    courseRepository.deleteById(id);
  }
}
