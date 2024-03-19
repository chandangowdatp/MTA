package com.mta.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class Offer {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OFFER_ID")
	private int offerId;
	
	@Column(name = "OFFER_DATE",columnDefinition = "DATE")
	private LocalDate offerDate;
	
	@Column(name = "OFFER_JOINING_DATE",columnDefinition = "TIMESTAMP")
	private LocalDateTime offerJoiningDate;
	
	@Column(name = "OFFER_STATUS")
	private String offerStatus;
	
	@Column(name = "OFFER_ACCEPT")
	private String offerAccept;
	
	@OneToOne(fetch =  FetchType.EAGER)
	@JoinColumn(name = "User_ID")
	private CAN_BASIC_DET basicId;
	
	@PrePersist
    public void prePersist() {
		offerJoiningDate = LocalDateTime.now();
    }

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public LocalDate getOfferDate() {
		return offerDate;
	}

	public void setOfferDate(LocalDate offerDate) {
		this.offerDate = offerDate;
	}

	public LocalDateTime getOfferJoiningDate() {
		return offerJoiningDate;
	}

	public void setOfferJoiningDate(LocalDateTime offerJoiningDate) {
		this.offerJoiningDate = offerJoiningDate;
	}

	public String getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}

	public String getOfferAccept() {
		return offerAccept;
	}

	public void setOfferAccept(String offerAccept) {
		this.offerAccept = offerAccept;
	}

	public CAN_BASIC_DET getBasicId() {
		return basicId;
	}

	public void setBasicId(CAN_BASIC_DET basicId) {
		this.basicId = basicId;
	}

	public Offer(int offerId, LocalDate offerDate, LocalDateTime offerJoiningDate, String offerStatus,
			String offerAccept, CAN_BASIC_DET basicId) {
		super();
		this.offerId = offerId;
		this.offerDate = offerDate;
		this.offerJoiningDate = offerJoiningDate;
		this.offerStatus = offerStatus;
		this.offerAccept = offerAccept;
		this.basicId = basicId;
	}

	public Offer() {
		super();
	}

	
}
