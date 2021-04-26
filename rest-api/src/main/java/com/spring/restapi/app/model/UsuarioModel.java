package com.spring.restapi.app.model;


public class UsuarioModel {
	
	private String nombre;
	
	private String apellido;
	
	private String celular;
	
	private String contrasena;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public UsuarioModel(String nombre, String apellido, String celular, String contrasena) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.contrasena = contrasena;
	}

	public UsuarioModel() {
	}
	
	
	
	
}
