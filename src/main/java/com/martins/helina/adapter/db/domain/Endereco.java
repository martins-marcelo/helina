package com.martins.helina.adapter.db.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Endereco {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEndereco;
	
	private String logradouro;
	
	private String numero;
	
	private String complemento;
	
	private String cidade;
	
	private String estado;
	
	private String cep;
	
}
