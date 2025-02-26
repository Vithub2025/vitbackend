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

import com.vitg.dto.TrainerDTO;
import com.vitg.service.TrainerService;

@RestController
@RequestMapping("/trainer")
@CrossOrigin
public class TrainerController { 

	@Autowired
	private TrainerService trainerService;
	
	@PostMapping("/addTrainer")
	public ResponseEntity<TrainerDTO> addTrainer(@RequestBody TrainerDTO trainerDTO){
		TrainerDTO trainer = trainerService.addTrainer(trainerDTO);
		return new ResponseEntity<>(trainer, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TrainerDTO> getTrainerById(@PathVariable int id){
		TrainerDTO trainerById = trainerService.getTrainerById(id);
		return new ResponseEntity<TrainerDTO>(trainerById, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<TrainerDTO>> getAllTrainers(){
		List<TrainerDTO> allTrainers = trainerService.getAllTrainers();
		return new ResponseEntity<List<TrainerDTO>>(allTrainers,HttpStatus.OK);
	}
}
