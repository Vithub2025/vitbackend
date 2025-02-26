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
	private TopicRepo topicRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public TopicDTO getTopicById(int id) {
		 Topic topic= topicRepository.findById(id);
		TopicDTO topicDTO = modelMapper.map(topic, TopicDTO.class );
		return topicDTO;
	}

	@Override
	public List<TopicDTO> getAllTopics() {
	List<Topic> topicList = topicRepository.findAll();
	List<TopicDTO>topicListDTO= new ArrayList<>();
	for (Topic topic:topicList) {
		TopicDTO topicDTO= modelMapper.map(topic,TopicDTO.class);
			topicListDTO.add(topicDTO);
	}
		return topicListDTO;
	}

	@Override
	public TopicDTO addTopic(TopicDTO topicDTO) {
		Topic topic = modelMapper.map(topicDTO, Topic.class);
		Topic topicResponce = topicRepository.save(topic);
		TopicDTO topicDTOResponce= modelMapper.map(topicResponce, TopicDTO.class);
		return topicDTOResponce;
	}

	@Override
	public List<TopicDTO> getTopicListBySubCourseId(int subCourseId) {
		List<Topic> topicList = topicRepository.findAll();
		List<TopicDTO> topicDTOList = new ArrayList<>();

		for(Topic topic: topicList) {
			if(topic.getSubCourse().getId() == subCourseId) {
				TopicDTO topicDTO = modelMapper.map(topic, TopicDTO.class);
				topicDTOList.add(topicDTO);
			}
		}
		return topicDTOList;
	}

}