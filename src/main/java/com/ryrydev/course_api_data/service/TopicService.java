package com.ryrydev.course_api_data.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ryrydev.course_api_data.entity.Topic;
import com.ryrydev.course_api_data.repository.TopicRepository;

@Service
public class TopicService {

  @Autowired
  private TopicRepository topicRepository;

  public List<Topic> getAllTopics() {
    List<Topic> topics = new ArrayList<>();
    topicRepository.findAll().forEach(topics::add);
    return topics;
  }

  public Topic getTopic(String id) {
    return topicRepository.findById(id).get();
  }

  public void addTopic(Topic topic) {
    topicRepository.save(topic);
  }

  public void updateTopic(String id, Topic topic) {
    topic.setId(id); // Ensure the ID is set for the update
    topicRepository.save(topic);
  }

  public void deleteTopic(String id) {
    topicRepository.deleteById(id);
  }


}