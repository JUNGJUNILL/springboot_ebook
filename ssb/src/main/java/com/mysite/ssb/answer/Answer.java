package com.mysite.ssb.answer;

import java.time.LocalDateTime;

import com.mysite.ssb.question.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	@Column(columnDefinition = "TEXT")
	private String content; 
	
	private LocalDateTime createDate; 
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Question  question; 

}
