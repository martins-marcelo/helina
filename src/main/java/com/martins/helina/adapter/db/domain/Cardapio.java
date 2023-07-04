package com.martins.helina.adapter.db.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Cardapio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCardapio;
	
	private Long idEstabelecimento;
	
	@OneToMany(mappedBy = "idCardapio", cascade = CascadeType.ALL)
	private List<ItemCardapio> itensCardapio;
}
