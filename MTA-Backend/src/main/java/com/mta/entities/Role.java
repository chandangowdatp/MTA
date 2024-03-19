package com.mta.entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
@DynamicUpdate
//@ToString
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "roleId")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLE_ID")
	private int roleId;
	
	public Role() {
		this.roleName = "User";
	}
	
	@Column(name = "ROLE_NAME", nullable = false,unique=true)
	private String roleName;
	@Column(name = "ROLE_STATUS")
	private String role_status;
	
	
	@OneToMany(mappedBy = "role",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Admin> admin= new ArrayList<>();
	
	@OneToMany(mappedBy = "role",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<CAN_BASIC_DET> user= new ArrayList<>();
	
//	 public Role() {
//	        this.admin = new ArrayList<>();
//	    }
	
	public Role(String roleName) {
        this.roleName = roleName;
        
    }
//	@OneToMany(mappedBy = "roleId", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Admin> admin = new ArrayList<>();

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRole_status() {
		return role_status;
	}

	public void setRole_status(String role_status) {
		this.role_status = role_status;
	}

	public List<Admin> getAdmin() {
		return admin;
	}

	public void setAdmin(List<Admin> admin) {
		this.admin = admin;
	}

	public List<CAN_BASIC_DET> getUser() {
		return user;
	}

	public void setUser(List<CAN_BASIC_DET> user) {
		this.user = user;
	}
	public Role(int roleId, String roleName, String role_status, List<Admin> admin, List<CAN_BASIC_DET> user) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.role_status = role_status;
		this.admin = admin;
		this.user = user;
	}
}
