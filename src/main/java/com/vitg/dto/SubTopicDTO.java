package com.vitg.dto;

import com.vitg.entity.Examples;
import com.vitg.entity.GithubLinks;
import com.vitg.entity.OtherLinks;
import com.vitg.entity.StudentMaterial;
import com.vitg.entity.TrainerPPT;
import com.vitg.entity.YoutubeLinks;

import lombok.Data;

@Data
public class SubTopicDTO {
	
	private int id;
	private TopicDTO topic;
	private String name;
	private String status;
	private StudentMaterial studentMaterial;
	private Examples examples;
	private TrainerPPT trainerPPT;
	private YoutubeLinks youtubeLinks;
	private GithubLinks githubLinks;
	private OtherLinks otherLinks;

}