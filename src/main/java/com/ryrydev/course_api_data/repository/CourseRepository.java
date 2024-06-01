package com.ryrydev.course_api_data.repository;

import com.ryrydev.course_api_data.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String> {
  List<Course> findByTopicId(String topicId);
}
