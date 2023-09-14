package com.vitg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.vitg.entity.Topic;

@Repository
public interface TopicRepo extends JpaRepository<Topic ,Integer> {
	
	Topic findById(int id);

}
