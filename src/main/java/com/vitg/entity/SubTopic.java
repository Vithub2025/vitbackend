package com.vitg.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="subTopic")
public class SubTopic implements Serializable{
	
	private static final long serialVersionUID = 1632815066777792760L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private int id;
	
	@Column(name = "course")
	private String course;
	
	@Column(name = "sub_course")
	private String subCourse;
	
	@Column(name = "topic")
	private String topic;
	
	@Column(name = "sub_topic")
	private String subTopic;
	
	@Column(name = "status")
	private String status;
	
//	@ManyToOne(targetEntity = Topic.class)
//	@JoinColumn(name = "topic_id", referencedColumnName="id")
//	private Topic topicData;

}
