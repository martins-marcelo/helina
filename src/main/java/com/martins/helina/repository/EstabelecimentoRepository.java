package com.martins.helina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martins.helina.adapter.db.domain.Estabelecimento;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long>{

}
