package com.vitg.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="subCourse")
public class SubCourse implements Serializable {
	
	private static final long serialVersionUID = -3826208943430374831L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "duration_days")
	private int durationDays;
	
	@Column(name = "duration_hours")
	private int durationHours;
	
	@Column(name = "fee")
	private int fee;
	
	@Column(name = "youtube_link")
	private String youtubeLink;
	
	@Column(name = "syllabus")
	private String syllabus;
	
	@Column(name = "exam_certification")
	private String examCertification;
	
	@Column(name = "overview")
	@Lob
	private String overview;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne(targetEntity = Course.class)
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	private Course course;

}
