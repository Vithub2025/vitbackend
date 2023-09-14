package com.vitg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitg.entity.Batch;
@Repository
public interface BatchRepo  extends JpaRepository<Batch,Integer> {
	

}
