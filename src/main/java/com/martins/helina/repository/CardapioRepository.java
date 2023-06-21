package com.martins.helina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martins.helina.adapter.db.domain.Cardapio;

public interface CardapioRepository extends JpaRepository<Cardapio, Long>{

}
