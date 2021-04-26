package com.spring.restapi.app.model;

import java.io.Serializable;

public class JwtRequest implements Serializable{

	private static final long serialVersionUID = -295740450976917676L;

	
	private String nombre;
	
	private String contrasena;

	public JwtRequest(String nombre, String contrasena) {
		this.nombre = nombre;
		this.contrasena = contrasena;
	}

	public JwtRequest() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
}
