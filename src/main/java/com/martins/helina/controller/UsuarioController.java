package com.martins.helina.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.martins.helina.controller.dto.UsuarioDTO;
import com.martins.helina.usecase.AlterarImagemUseCase;
import com.martins.helina.usecase.CadastrarUsuarioUseCase;
import com.martins.helina.usecase.RecuperarDetalhesUsuarioUseCase;
import com.martins.helina.usecase.RecuperarImagemUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;
	
	private final RecuperarDetalhesUsuarioUseCase recuperarDetalhesUsuarioUseCase;
	
	private final AlterarImagemUseCase alterarImagemUseCase;
	
	private final RecuperarImagemUseCase recuperarImagemUseCase;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
		UsuarioDTO usuarioCadastrado = cadastrarUsuarioUseCase.execute(usuarioDTO);
		return ResponseEntity.ok().body(usuarioCadastrado);
	}
	
	@GetMapping("/detalhes/{idUsuario}")
	public ResponseEntity<UsuarioDTO> recuperarDetalhesUsuario(@PathVariable Long idUsuario){
		UsuarioDTO usuarioDetalhado = recuperarDetalhesUsuarioUseCase.execute(idUsuario);
		return ResponseEntity.ok().body(usuarioDetalhado);
	}
	
	@PostMapping(value = "/salvar-imagem/{idUsuario}" ,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void salvarFotoPerfil(@PathVariable Long idUsuario, @RequestParam("fotoPerfil") MultipartFile fotoPerfil) {
		alterarImagemUseCase.execute(idUsuario, fotoPerfil);
    }

    @GetMapping(value = "/recuperar-imagem", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] recuperarFotoPerfil(@PathVariable Long id) {
        return recuperarImagemUseCase.execute(id);
    }
	
}
