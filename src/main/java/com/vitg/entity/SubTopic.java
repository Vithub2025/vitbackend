package com.vitg.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
	
	@Column(name = "name")
	private String name;

	@ManyToOne(targetEntity = Topic.class)
	@JoinColumn(name = "topic_id", referencedColumnName="id")
	private Topic topic;
	
	@Column(name = "status")
	private String status;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER, targetEntity = StudentMaterial.class)
	@JoinColumn(name = "student_material_id", referencedColumnName = "id")
	private StudentMaterial studentMaterial;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER, targetEntity = TrainerPPT.class)
	@JoinColumn(name = "trainer_ppt_id", referencedColumnName = "id")
	private TrainerPPT trainerPPT;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER, targetEntity = Examples.class)
	@JoinColumn(name = "examples_id", referencedColumnName = "id")
	private Examples examples;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER, targetEntity = YoutubeLinks.class)
	@JoinColumn(name = "youtube_links_id", referencedColumnName = "id")
	private YoutubeLinks youtubeLinks;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER, targetEntity = GithubLinks.class)
	@JoinColumn(name = "github_links_id", referencedColumnName = "id")
	private GithubLinks GithubLinks;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER, targetEntity = OtherLinks.class)
	@JoinColumn(name = "other_links_id", referencedColumnName = "id")
	private OtherLinks otherLinks;

}
