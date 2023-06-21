package com.martins.helina.adapter.db.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
