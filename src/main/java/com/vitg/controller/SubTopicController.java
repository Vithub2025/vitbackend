package com.vitg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitg.dto.SubTopicDTO;
import com.vitg.service.SubTopicService;

@RestController
@RequestMapping("/api/subTopic")
public class SubTopicController {

	@Autowired
	private SubTopicService subtopicservice; 
	
	@PostMapping("/addSubTopic")
	public ResponseEntity<SubTopicDTO> addSubTopic(@RequestBody SubTopicDTO subtopicDTO){
		SubTopicDTO subtopicData = subtopicservice.addSubTopic(subtopicDTO);
		return new ResponseEntity<>(subtopicData, HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<SubTopicDTO> getSubTopicById(@PathVariable int id){
		SubTopicDTO subtopicData = subtopicservice.getSubTopicById(id);
		return new ResponseEntity<>(subtopicData, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<SubTopicDTO>> getAllSubTopics(){
		List<SubTopicDTO> allSubTopics = subtopicservice.getAllSubTopics();
		return new ResponseEntity<>(allSubTopics, HttpStatus.OK); 
	}
}
