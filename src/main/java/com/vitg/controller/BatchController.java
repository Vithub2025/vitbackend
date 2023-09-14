package com.vitg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitg.dto.BatchDTO;

import com.vitg.service.BatchService;

@RestController
@RequestMapping("/batch")
public class BatchController {
	
	@Autowired
	private BatchService batchService;
	
	@GetMapping("/{id}")
	public BatchDTO getBatchesById(@PathVariable int id) {
		BatchDTO Batch = batchService.getBatchById(id);
		return Batch;
}
	@GetMapping("/all")
	public List<BatchDTO> getAllBatches(){
		return batchService.getAllBatches();
}
	@PostMapping("/addBatch")
	public BatchDTO addBatch(@RequestBody BatchDTO BatchDTO) {
		BatchDTO BatchDTOResponse = batchService.addBatch(BatchDTO);
		return BatchDTOResponse;
	}
	}