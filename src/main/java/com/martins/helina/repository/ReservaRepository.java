package com.martins.helina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martins.helina.adapter.db.domain.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}
