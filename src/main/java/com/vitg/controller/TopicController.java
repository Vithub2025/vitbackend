package com.vitg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.vitg.dto.TopicDTO;
import com.vitg.service.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController {

	@Autowired
	private TopicService TopicService;

	@GetMapping("/{id}")
	public TopicDTO getTopicById(@PathVariable("id")int id) {
		TopicDTO topic =TopicService.getTopicById(id);
		return topic;
	}

	@GetMapping("/getAllTopics")
	public List<TopicDTO> getAllTopic(){
		return TopicService.getAllTopics();
	}

	@PostMapping("/addTopic")
	public TopicDTO addTopic( @RequestBody TopicDTO topicDTO) {
		TopicDTO topicDTOResponse = TopicService.addTopic(topicDTO);
		return topicDTOResponse;
	}
	
}
