package com.martins.helina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martins.helina.controller.dto.ReservaDTO;
import com.martins.helina.usecase.AtualizarStatusReservaUseCase;
import com.martins.helina.usecase.ReservarUseCase;
import com.martins.helina.usecase.ReservasPorUsuarioUseCase;
import com.martins.helina.usecase.ReservasPorEstabelecimentoUseCase;

@RestController
@RequestMapping("/v1/reserva")
public class ReservaController {
	
	@Autowired
	private ReservarUseCase reservarUseCase;
	@Autowired
	private ReservasPorEstabelecimentoUseCase reservasPorEstabelecimentoUseCase;
	@Autowired
	private ReservasPorUsuarioUseCase reservasPorClienteUseCase;
	@Autowired
	private AtualizarStatusReservaUseCase atualizarStatusReservaUseCase;
	
	@PostMapping
	public ResponseEntity<Void> reservar(@RequestBody ReservaDTO reservaDTO) throws Exception {
		reservarUseCase.execute(reservaDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PostMapping("/atualizar")
	public ResponseEntity<Boolean> atualizarStatusReserva(@RequestBody ReservaDTO reservaDTO) throws Exception {
		var resposta = atualizarStatusReservaUseCase.execute(reservaDTO);
		return ResponseEntity.ok().body(resposta);
	}
	
	@GetMapping("/listar/{idEstabelecimento}")
	public ResponseEntity<List<ReservaDTO>> recuperarReservasPorEstabelecimento(@PathVariable String idEstabelecimento) throws Exception {
		var resposta = reservasPorEstabelecimentoUseCase.execute(idEstabelecimento);
		return ResponseEntity.ok().body(resposta);
	}
	
	@GetMapping("/listar/{idCliente}")
	public ResponseEntity<List<ReservaDTO>> recuperarReservasPorCliente(@PathVariable String idUsuario) throws Exception {
		var resposta = reservasPorClienteUseCase.execute(idUsuario);
		return ResponseEntity.ok().body(resposta);
	}
}
