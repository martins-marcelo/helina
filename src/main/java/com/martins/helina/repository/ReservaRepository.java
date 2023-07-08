package com.martins.helina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martins.helina.adapter.db.domain.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{
	
	List<Reserva> findByIdUsuario(Long idUsuario);
	
	List<Reserva> findByIdEstabelecimento(Long idEstabelecimento);

}
