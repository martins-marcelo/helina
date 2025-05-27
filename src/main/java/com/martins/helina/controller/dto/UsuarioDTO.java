package com.martins.helina.controller.dto;

import java.util.Set;

import com.martins.helina.controller.dto.enums.Perfil;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class UsuarioDTO {

	private String id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private Set<Perfil> perfis;
	
	private EnderecoDTO endereco;
	
	private byte[] fotoPerfil;
}
