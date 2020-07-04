package com.bizauth.model;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;
	/*
	 * private String clientId; private String secretKey;
	 */
	
	//need default constructor for JSON Parsing
	public JwtRequest()
	{
		
	}

	
	/*
	 * public String getClientId() { return clientId; }
	 * 
	 * 
	 * public void setClientId(String clientId) { this.clientId = clientId; }
	 * 
	 * 
	 * public String getSecretKey() { return secretKey; }
	 * 
	 * 
	 * public void setSecretKey(String secretKey) { this.secretKey = secretKey; }
	 * 
	 */
	public JwtRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
		/*
		 * this.setClientId(clientId); this.setSecretKey(secretKey);
		 */
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}