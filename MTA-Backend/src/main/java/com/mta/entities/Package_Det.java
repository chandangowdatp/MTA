package com.mta.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;


@Entity
public class Package_Det {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PACKAGE_ID")
	private int packageId;
	private String ctc;
	private String ectc;
	
	@Column(name = "NOTICE_PERIOD")
	private String noticePeriod;
	
	@Column(name = "PACKAGE_DATE_TIME",columnDefinition = "TIMESTAMP")
	private LocalDateTime packageDateTime;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "Pkg_UserId")
	private List<CAN_BASIC_DET> user= new ArrayList<>();
	
	@PrePersist
    public void prePersist() {
		packageDateTime = LocalDateTime.now();
    }

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getCtc() {
		return ctc;
	}

	public void setCtc(String ctc) {
		this.ctc = ctc;
	}

	public String getEctc() {
		return ectc;
	}

	public void setEctc(String ectc) {
		this.ectc = ectc;
	}

	public String getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public LocalDateTime getPackageDateTime() {
		return packageDateTime;
	}

	public void setPackageDateTime(LocalDateTime packageDateTime) {
		this.packageDateTime = packageDateTime;
	}

	public List<CAN_BASIC_DET> getUser() {
		return user;
	}

	public void setUser(List<CAN_BASIC_DET> user) {
		this.user = user;
	}

	public Package_Det(int packageId, String ctc, String ectc, String noticePeriod, LocalDateTime packageDateTime,
			List<CAN_BASIC_DET> user) {
		super();
		this.packageId = packageId;
		this.ctc = ctc;
		this.ectc = ectc;
		this.noticePeriod = noticePeriod;
		this.packageDateTime = packageDateTime;
		this.user = user;
	}

	public Package_Det() {
		super();
	}
	
	
}
