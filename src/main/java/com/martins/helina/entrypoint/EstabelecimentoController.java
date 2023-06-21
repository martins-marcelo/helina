package com.martins.helina.entrypoint;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martins.helina.ObjectNotFoundException;
import com.martins.helina.entrypoint.dto.EstabelecimentoDTO;
import com.martins.helina.usecase.CadastrarEstabelecimentoUseCase;
import com.martins.helina.usecase.RecuperarDetalhesEstabelecimentoUseCase;
import com.martins.helina.usecase.RecuperarEstabelecimentosUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {

	private final CadastrarEstabelecimentoUseCase cadastrarEstabelecimentoUseCase;

	private final RecuperarDetalhesEstabelecimentoUseCase recuperarDetalhesEstabelecimentoUseCase;
	
	private final RecuperarEstabelecimentosUseCase recuperarEstabelecimentosUseCase;

	@PostMapping("/cadastrar")
	public ResponseEntity<EstabelecimentoDTO> cadastrarEstabelecimento(@RequestBody EstabelecimentoDTO estabelecimentoDTO) {
		var estabelecimentoCadastrado = cadastrarEstabelecimentoUseCase.execute(estabelecimentoDTO);
		return ResponseEntity.ok().body(estabelecimentoCadastrado);
	}

	@GetMapping("/detalhes/{idEstabelecimento}")
	public ResponseEntity<EstabelecimentoDTO> recuperarDetalhesEstabelecimento(@PathVariable Long idEstabelecimento) throws ObjectNotFoundException {
		var estabelecimentoDetalhado = recuperarDetalhesEstabelecimentoUseCase.execute(idEstabelecimento);
		return ResponseEntity.ok().body(estabelecimentoDetalhado);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<EstabelecimentoDTO>> recuperarEstabelecimentos() {
		var estabelecimentos = recuperarEstabelecimentosUseCase.execute();
		return ResponseEntity.ok().body(estabelecimentos);
	}

}
