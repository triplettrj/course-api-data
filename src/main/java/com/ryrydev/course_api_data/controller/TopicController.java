package com.ryrydev.course_api_data.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ryrydev.course_api_data.entity.Topic;
import com.ryrydev.course_api_data.service.TopicService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TopicController {

  @Autowired
  private TopicService topicService;

  @GetMapping("/topics")
  public List<Topic> getAllTopics() {
    return topicService.getAllTopics();
  }

  @GetMapping("/topics/{id}")
  public Topic getTopic(@PathVariable String id) {
    return topicService.getTopic(id);
  }

  @PostMapping("/topics")
  public void addTopic(@RequestBody Topic topic) {
    topicService.addTopic(topic);
  }

  @DeleteMapping("/topics/{id}")
  public void deleteTopic(@PathVariable String id) {
    topicService.deleteTopic(id);
  } 

  @PutMapping("/topics/{id}")
  public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
    topicService.updateTopic(topic);
  }

}
