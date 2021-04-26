package com.spring.restapi.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.restapi.app.entity.Usuario;
import com.spring.restapi.app.model.UsuarioModel;
import com.spring.restapi.app.repository.UsuarioRepository;

@Service
public class JwtUsuarioDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNombre(nombre);
		if (usuario == null) {
			throw new UsernameNotFoundException("No se ha encontrado usuario con el nombre de: " + nombre);
		}
		return new org.springframework.security.core.userdetails.User(usuario.getNombre(), usuario.getContrasena(),
				new ArrayList<>());
	}
	
	public Usuario save(UsuarioModel user) {
		Usuario newUsuario = new Usuario();
		newUsuario.setNombre(user.getNombre());
		newUsuario.setApellido(user.getApellido());
		newUsuario.setCelular(user.getCelular());
		newUsuario.setContrasena(bcryptEncoder.encode(user.getContrasena()));
		return usuarioRepository.save(newUsuario);
	}
}
