package com.vitg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitg.entity.SubTopic;

@Repository
public interface SubTopicRepo extends JpaRepository<SubTopic, Integer> {
	SubTopic findById(int id);
}