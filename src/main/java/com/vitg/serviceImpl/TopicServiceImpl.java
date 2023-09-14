package com.vitg.serviceImpl;

import java.util.ArrayList;
import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitg.dto.TopicDTO;
import com.vitg.entity.Topic;
import com.vitg.repository.TopicRepo;
import com.vitg.service.TopicService;
@Service
public class TopicServiceImpl implements TopicService {
   
	@Autowired
	private TopicRepo topicRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public TopicDTO getTopicById(int id) {
		 Topic topic= topicRepo.findById(id);
		TopicDTO topicDTO =modelMapper.map(topic, TopicDTO.class );
		return topicDTO;
	}

	@Override
	public List<TopicDTO> getAllTopics() {
	List<Topic> topicList =topicRepo.findAll();
	List<TopicDTO>topicListDTO= new ArrayList<>();
	for (Topic topic:topicList) {
		TopicDTO topicDTO=modelMapper.map(topic,TopicDTO.class);
			topicListDTO.add(topicDTO);
	}
		return topicListDTO;
	}

	@Override
	public TopicDTO addTopic(TopicDTO topicDTO) {
		Topic topic =modelMapper.map(topicDTO, Topic.class);
		Topic topicResponce=topicRepo.save(topic);
		TopicDTO topicDTOResponce=modelMapper.map(topicResponce, TopicDTO.class);
		return topicDTOResponce;
	}

}