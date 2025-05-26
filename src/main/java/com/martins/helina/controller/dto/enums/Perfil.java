package com.martins.helina.controller.dto.enums;

public enum Perfil {
	ADMIN(1, "ROLE_ADMIN"),
	ESTABELECIMENTO_USER(2, "ROLE_ESTABELECIMENTO_USER"),
	ESTABELECIMENTO_OWNER(3, "ROLE_ESTABELECIMENTO_OWNER"),
	CLIENTE_USER(4, "ROLE_CLIENTE_USER");
	
	private int codigo;
	private String descricao;
	
	private Perfil(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	public String getDescricao() {
		return this.descricao;
	}
	
	public static Perfil toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (Perfil perfil : Perfil.values()) {
			if(cod.equals(perfil.getCodigo())) {
				return perfil;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
}
