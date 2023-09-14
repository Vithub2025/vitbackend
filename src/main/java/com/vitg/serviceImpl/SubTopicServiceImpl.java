package com.vitg.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitg.dto.SubTopicDTO;
import com.vitg.entity.SubTopic;
import com.vitg.repository.SubTopicRepo;
import com.vitg.service.SubTopicService;

@Service
public class SubTopicServiceImpl implements SubTopicService {
	
	@Autowired
	private SubTopicRepo subTopicRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<SubTopicDTO> getAllSubTopics() {
		List<SubTopic> subTopicData = subTopicRepo.findAll();
		List<SubTopicDTO> subTopicDTOList = new ArrayList<>();
		for(SubTopic subTopic : subTopicData) {
			SubTopicDTO subTopicDTO = modelMapper.map(subTopic, SubTopicDTO.class);
			subTopicDTOList.add(subTopicDTO);
		}
		return subTopicDTOList;
	}

	@Override
	public SubTopicDTO addSubTopic(SubTopicDTO subTopicDTO) {
		SubTopic subTopicData = modelMapper.map(subTopicDTO, SubTopic.class);
		SubTopic subtopic = subTopicRepo.save(subTopicData);
		SubTopicDTO subTopicDTOFinal = modelMapper.map(subtopic, SubTopicDTO.class);
		return subTopicDTOFinal;
	}

	@Override
	public SubTopicDTO getSubTopicById(int id) {
		SubTopic subTopicData = subTopicRepo.findById(id);
		SubTopicDTO subTopicDTO = modelMapper.map(subTopicData, SubTopicDTO.class);
		return subTopicDTO;
	}

}
