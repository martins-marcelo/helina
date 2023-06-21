package com.martins.helina.adapter.db.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Estabelecimento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstabelecimento;
	
	private Long cnpj;
	
	private String razaoSocial;
	
	private String nomeFantasia;
	
	private String tipoReserva;
	
	private Integer totalVagas;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cardapio", referencedColumnName = "idCardapio")
	private Cardapio cardapio;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco", referencedColumnName = "idEndereco")
	private Endereco endereco;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Cronograma> diasAbertura;
	

}
