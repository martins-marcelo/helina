package com.martins.helina.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martins.helina.controller.dto.EstabelecimentoDTO;
import com.martins.helina.exception.ObjectNotFoundException;
import com.martins.helina.usecase.AtualizarEstabelecimentoUseCase;
import com.martins.helina.usecase.CadastrarEstabelecimentoUseCase;
import com.martins.helina.usecase.RecuperarDetalhesEstabelecimentoUseCase;
import com.martins.helina.usecase.RecuperarEstabelecimentosUseCase;
import com.martins.helina.usecase.RecuperarImagemEstabelecimentoUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {

	private final CadastrarEstabelecimentoUseCase cadastrarEstabelecimentoUseCase;

	private final RecuperarDetalhesEstabelecimentoUseCase recuperarDetalhesEstabelecimentoUseCase;
	
	private final RecuperarEstabelecimentosUseCase recuperarEstabelecimentosUseCase;
	
	private final AtualizarEstabelecimentoUseCase atualizarEstabelecimentoUseCase;
	
	private final RecuperarImagemEstabelecimentoUseCase recuperarImagemEstabelecimentoUseCase;

	@PostMapping("/cadastrar")
	public ResponseEntity<Void> cadastrarEstabelecimento(@RequestBody EstabelecimentoDTO estabelecimentoDTO) {
		cadastrarEstabelecimentoUseCase.execute(estabelecimentoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping("/detalhes/{idEstabelecimento}")
	public ResponseEntity<EstabelecimentoDTO> recuperarDetalhesEstabelecimento(@PathVariable String idEstabelecimento) throws ObjectNotFoundException {
		var estabelecimentoDetalhado = recuperarDetalhesEstabelecimentoUseCase.execute(idEstabelecimento);
		return ResponseEntity.ok().body(estabelecimentoDetalhado);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<EstabelecimentoDTO>> recuperarEstabelecimentos() {
		var estabelecimentos = recuperarEstabelecimentosUseCase.execute();
		return ResponseEntity.ok().body(estabelecimentos);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<EstabelecimentoDTO> atualizarEstabelecimento(@RequestBody EstabelecimentoDTO estabelecimentoDTO) throws ObjectNotFoundException{
		var estabelecimento = atualizarEstabelecimentoUseCase.execute(estabelecimentoDTO);
		return ResponseEntity.ok().body(estabelecimento);
	}
	
	@GetMapping(value = "/imagem/{idEstabelecimento}/{flBanner}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> recuperarFotoPerfil(@PathVariable Long idEstabelecimento, @PathVariable String flBanner) {
        var imagem = recuperarImagemEstabelecimentoUseCase.execute(idEstabelecimento, flBanner);
        return ResponseEntity.ok().body(imagem);
    }

}
