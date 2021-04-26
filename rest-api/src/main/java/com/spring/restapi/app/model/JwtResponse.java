package com.spring.restapi.app.model;

import java.io.Serializable;

public class JwtResponse implements Serializable{

	private static final long serialVersionUID = -1536682818806343999L;

	private final String jwttoken;

	
	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}


	public String getJwttoken() {
		return jwttoken;
	}
	
	
}
