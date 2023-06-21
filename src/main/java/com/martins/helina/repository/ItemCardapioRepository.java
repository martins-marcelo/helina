package com.martins.helina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martins.helina.adapter.db.domain.ItemCardapio;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, Long>{

}
