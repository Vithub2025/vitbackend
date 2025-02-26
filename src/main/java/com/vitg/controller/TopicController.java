package com.vitg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class TopicController {

	@Autowired
	private TopicService topicService;

	@GetMapping("/{id}")
	public TopicDTO getTopicById(@PathVariable("id")int id) {
		TopicDTO topic = topicService.getTopicById(id);
		return topic;
	}

	@GetMapping("/all")
	public List<TopicDTO> getAllTopic(){
		return topicService.getAllTopics();
	}

	@PostMapping("/addTopic")
	public TopicDTO addTopic(@RequestBody TopicDTO topicDTO) {
		TopicDTO topicDTOResponse = topicService.addTopic(topicDTO);
		return topicDTOResponse;
	}
	@GetMapping("/getTopicListBySubCourseId/{subCourseId}")
	public ResponseEntity<List<TopicDTO>> getTopicListBySubCourseId(@PathVariable int subCourseId) {
		List<TopicDTO> topicDTOResponse = topicService.getTopicListBySubCourseId(subCourseId);
		return new ResponseEntity<>(topicDTOResponse, HttpStatus.OK);
	}
}