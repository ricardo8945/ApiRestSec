package com.spring.restapi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.restapi.app.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findByNombre(String Nombre);
}
