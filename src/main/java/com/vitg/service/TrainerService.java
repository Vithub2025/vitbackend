package com.vitg.service;

import java.util.List;

import com.vitg.dto.TrainerDTO;

public interface TrainerService {

	TrainerDTO addTrainer(TrainerDTO trainerDTO);
	TrainerDTO getTrainerById(int id);
	List<TrainerDTO> getAllTrainers();
}
