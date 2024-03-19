package com.mta.entities;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;



@Entity
public class Interview_Status {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INTERVIEW_ID")
	private int interviewId;
	@Column(name = "LEVEL_STATUS")
	private String levelstatus;
	
	@Column(name = "INTERVIEW_DATE_TIME",columnDefinition = "TIMESTAMP")
	private LocalDateTime interviewDateTime;
	
	@Column(name = "HACKER_RANK_STATUS")
	private String hacker_Rank_Status;
	
	@OneToOne(cascade = CascadeType.ALL,fetch =  FetchType.EAGER)
	@JoinColumn(name="USER_ID")
	private CAN_BASIC_DET user;
	
	
	 @PrePersist
	    public void prePersist() {
		 interviewDateTime = LocalDateTime.now();
	    }


	public int getInterviewId() {
		return interviewId;
	}


	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}


	public String getLevelstatus() {
		return levelstatus;
	}


	public void setLevelstatus(String levelstatus) {
		this.levelstatus = levelstatus;
	}


	public LocalDateTime getInterviewDateTime() {
		return interviewDateTime;
	}


	public void setInterviewDateTime(LocalDateTime interviewDateTime) {
		this.interviewDateTime = interviewDateTime;
	}


	public String getHacker_Rank_Status() {
		return hacker_Rank_Status;
	}


	public void setHacker_Rank_Status(String hacker_Rank_Status) {
		this.hacker_Rank_Status = hacker_Rank_Status;
	}


	public CAN_BASIC_DET getUser() {
		return user;
	}


	public void setUser(CAN_BASIC_DET user) {
		this.user = user;
	}


	public Interview_Status(int interviewId, String levelstatus, LocalDateTime interviewDateTime,
			String hacker_Rank_Status, CAN_BASIC_DET user) {
		super();
		this.interviewId = interviewId;
		this.levelstatus = levelstatus;
		this.interviewDateTime = interviewDateTime;
		this.hacker_Rank_Status = hacker_Rank_Status;
		this.user = user;
	}


	public Interview_Status() {
		super();
	}
	
}
