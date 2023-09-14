package com.vitg.service;

import java.util.List;

import com.vitg.dto.BatchDTO;

public interface BatchService {
	
	BatchDTO getBatchById(int id);
	List<BatchDTO> getAllBatches();
	BatchDTO addBatch(BatchDTO batchDTO);
  
}
