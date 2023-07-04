package com.martins.helina.adapter.db.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ItemCardapio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idItem;
	
	@ManyToOne
	private Cardapio idCardapio;
	
	private String nmItem;
	
	private BigDecimal preco;

}
