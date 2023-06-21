package com.martins.helina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martins.helina.adapter.db.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
