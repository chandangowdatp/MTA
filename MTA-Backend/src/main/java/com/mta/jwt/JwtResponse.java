package com.mta.jwt;


public class JwtResponse {
	
	private Object user;
	private String token;
	
	public JwtResponse(Object user, String token) {
		super();
		this.user = user;
		this.token = token;
	}
	
	
	public JwtResponse() {
		super();
	}


	public Object getUser() {
		return user;
	}
	public void setUser(Object user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

}
