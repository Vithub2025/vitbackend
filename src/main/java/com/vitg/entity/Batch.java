package com.vitg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Entity
@Table(name="batch")
public class Batch {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  //private static final long serialVersionUID = 4130758031076098234L;
 
	@Column ( name = "id")
	private int id;
	
	@Column ( name = "batch_Code")
	private String batchCode;
	
	@Column ( name = "batch_Name")
	private String batchName;
	
	@Column ( name = "trainer")
	private String trainer;
	
	@Column ( name  = "status")
	private String status;
	
	@Column ( name = "satrt_date")
	private String startDate;
	
	@Column ( name = " end_date")
	private String endDate;
	
	@Column ( name = " course")
	private String course;
	
	@Column ( name = "sub_course")
	private String subCourse;
	
	@Column ( name = "fee")
	private String fee;
	
	@Column ( name = "organiser")
	private String organizer;
	
	@Column ( name = "description ")
	private String description;
	
	@Column ( name = " demo_link")
	private String demoLink;
	
	
	


}
