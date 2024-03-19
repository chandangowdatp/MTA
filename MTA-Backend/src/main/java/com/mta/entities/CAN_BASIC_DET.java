package com.mta.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;


@Entity
@DynamicUpdate
@DynamicInsert
public class CAN_BASIC_DET implements UserDetails {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAN_BASIC_ID")
	private int userId;
	@Column(name = "CAN_FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name = "CAN_MIDDLE_NAME")
	private String MiddleName;
	@Column(name = "CAN_LAST_NAME", nullable = false)
	private String lastName;
	
	@Column(name = "CAN_DOB", nullable = false,columnDefinition = "DATE")
	private LocalDate dob ;
	@Column(name = "CAN_GENDER",nullable = false)
	private String gender;
	@Column(name = "CAN_MOBILE")
	private String mobile;
	@Column(name="CAN_EMAIL",unique = true)
	private String email;
	@Column(name = "CAN_CURRENT_LOCATION")
	private String currentLocation;
	@Column(name = "CAN_PREFERED_LOCATION")
	private String prefered_location;
	@Column(name = "CAN_COUNTRY")
	private String country;
	
    @Column(name = "CAN_BASIC_DATE_TIME", updatable = false,columnDefinition = "TIMESTAMP")
	private LocalDateTime basicDateTime; 
    
    @PrePersist
    public void prePersist() {
    	basicDateTime = LocalDateTime.now();
    }
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinColumn(name = "ROLE_ID")
    private Role role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getPrefered_location() {
		return prefered_location;
	}

	public void setPrefered_location(String prefered_location) {
		this.prefered_location = prefered_location;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDateTime getBasicDateTime() {
		return basicDateTime;
	}

	public void setBasicDateTime(LocalDateTime basicDateTime) {
		this.basicDateTime = basicDateTime;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CAN_BASIC_DET(int userId, String firstName, String middleName, String lastName, LocalDate dob, String gender,
			String mobile, String email, String currentLocation, String prefered_location, String country,
			LocalDateTime basicDateTime, Role role) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		MiddleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.currentLocation = currentLocation;
		this.prefered_location = prefered_location;
		this.country = country;
		this.basicDateTime = basicDateTime;
		this.role = role;
	}

	public CAN_BASIC_DET() {
		super();
	}

}
