package com.martins.helina.adapter.db.domain;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
