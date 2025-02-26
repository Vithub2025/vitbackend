package com.vitg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitg.entity.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

	Trainer findById(int id);
}