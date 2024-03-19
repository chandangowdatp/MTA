package com.mta.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Admin implements UserDetails {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_DET_ID")
	private int userId;
	
	@Column(name = "USER_NAME", nullable = false, unique = true)
	private String email;

	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private Role role;
//	

//	@ManyToOne
//	private Role roleId;

	@Column(name = "USER_STATUS")
	private String userStatus;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.getRoleName()));
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Admin(int userId, String email, String password, Role role, String userStatus) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.role = role;
		this.userStatus = userStatus;
	}

	public Admin() {
		super();
	}

	@Override
	public String toString() {
		return "Admin [userId=" + userId + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", userStatus=" + userStatus + "]";
	}



}
