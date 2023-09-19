package com.vitg.service;

import java.util.List;

import com.vitg.dto.SubTopicDTO;

public interface SubTopicService {

	public SubTopicDTO addSubTopic(SubTopicDTO subTopicDTO);
	public SubTopicDTO getSubTopicById(int id);
	public List<SubTopicDTO> getAllSubTopics();
	
}
