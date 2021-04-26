package com.spring.restapi.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restapi.app.entity.Usuario;
import com.spring.restapi.app.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	
	//Crear usuario
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
	}
	
	//Leer
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<Usuario> oUsuario = usuarioService.findById(id);
		if (!oUsuario.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(oUsuario);
	}
	
	//Actualizar
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Usuario usuario, @PathVariable Long id){
		Optional<Usuario> oUsuario = usuarioService.findById(id);
		if(!oUsuario.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		oUsuario.get().setNombre(usuario.getNombre());
		oUsuario.get().setApellido(usuario.getApellido());
		oUsuario.get().setCelular(usuario.getCelular());
		oUsuario.get().setContrasena(bcryptEncoder.encode(usuario.getContrasena()));
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(oUsuario.get()));
	}
	
	//Eliminar
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		if(!usuarioService.findById(id).isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		usuarioService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	//todos los Usuario
	@GetMapping
	public List<Usuario> readAll(){
		List<Usuario> usuarios = StreamSupport.
				stream(usuarioService.findAll().spliterator(), false).
				collect(Collectors.toList());
		return usuarios;
	}
}
