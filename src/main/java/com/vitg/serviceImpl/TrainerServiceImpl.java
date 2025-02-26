package com.vitg.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitg.dto.TrainerDTO;
import com.vitg.entity.Trainer;
import com.vitg.repository.BatchRepo;
import com.vitg.repository.TrainerRepository;
import com.vitg.service.TrainerService;

@Service
public class TrainerServiceImpl implements TrainerService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private TrainerRepository trainerRepo;
	
	@Autowired
	private BatchRepo batchRepo;
	
	@Override
	public TrainerDTO addTrainer(TrainerDTO trainerDTO) {
		batchRepo.findById(trainerDTO.getBatch().getId());
		Trainer trainerData = modelMapper.map(trainerDTO, Trainer.class);
		Trainer trainer = trainerRepo.save(trainerData);
		TrainerDTO trainerDTOFinal = modelMapper.map(trainer, TrainerDTO.class);
		return trainerDTOFinal;
	}

	@Override
	public TrainerDTO getTrainerById(int id) {
		Trainer trainer = trainerRepo.findById(id);
		TrainerDTO trainerDTO = modelMapper.map(trainer, TrainerDTO.class);
		return trainerDTO;
	}

	@Override
	public List<TrainerDTO> getAllTrainers() {
		List<Trainer> findAll = trainerRepo.findAll();
		List<TrainerDTO> trainerDTOList = new ArrayList<>();
		for(Trainer trainer : findAll) {
			TrainerDTO trainerDTO = modelMapper.map(trainer, TrainerDTO.class);
			trainerDTOList.add(trainerDTO);
		}
		return trainerDTOList;
	}
}
