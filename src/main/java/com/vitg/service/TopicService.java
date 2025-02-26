package com.vitg.service;

import java.util.List;

import com.vitg.dto.TopicDTO;

public interface TopicService {
	
	TopicDTO getTopicById(int id);
	List<TopicDTO> getAllTopics();
	TopicDTO addTopic(TopicDTO topicDTO);
	public List<TopicDTO> getTopicListBySubCourseId(int subCourseId);
}