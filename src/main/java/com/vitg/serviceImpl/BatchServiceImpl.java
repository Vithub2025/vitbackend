package com.vitg.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitg.dto.BatchDTO;
import com.vitg.entity.Batch;
import com.vitg.repository.BatchRepo;
import com.vitg.service.BatchService;

@Service
public class BatchServiceImpl implements  BatchService {
   @Autowired
	private BatchRepo batchRepo;
   
   @Autowired
   private ModelMapper modelMapper;
   
	@Override
	public BatchDTO getBatchById(int id) {
		Optional<Batch> batch=batchRepo.findById(id);
		BatchDTO batchDTO =modelMapper.map(batch, BatchDTO.class);
		return batchDTO;
	}

	@Override
	public List<BatchDTO> getAllBatches() {
		List<Batch>batchList=batchRepo.findAll();
		List<BatchDTO>batchListDTO=new ArrayList<>();
		for (Batch batch:batchList) {
			BatchDTO batchDTO=modelMapper.map(batch,BatchDTO.class );
			batchListDTO.add(batchDTO);
		}
		return batchListDTO;
	}

	@Override
	public BatchDTO addBatch(BatchDTO batchDTO) {
		Batch batch=modelMapper.map( batchDTO,Batch.class );
		Batch batchResponce=batchRepo.save(batch);
		BatchDTO batchDTOResponce=modelMapper.map(batchResponce, BatchDTO.class);
	
		return batchDTOResponce;
	}

	
	}

	

	


