package com.martins.helina.entrypoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martins.helina.entrypoint.dto.ReservaDTO;
import com.martins.helina.usecase.AtualizarStatusReservaUseCase;
import com.martins.helina.usecase.ReservarUseCase;
import com.martins.helina.usecase.ReservasPorClienteUseCase;
import com.martins.helina.usecase.ReservasPorEstabelecimentoUseCase;

@RestController
@RequestMapping("/v1/reserva")
public class ReservaController {
	
	@Autowired
	private ReservarUseCase reservarUseCase;
	@Autowired
	private ReservasPorEstabelecimentoUseCase reservasPorEstabelecimentoUseCase;
	@Autowired
	private ReservasPorClienteUseCase reservasPorClienteUseCase;
	@Autowired
	private AtualizarStatusReservaUseCase atualizarStatusReservaUseCase;
	
	@PostMapping
	public ResponseEntity<ReservaDTO> reservar(@RequestBody ReservaDTO reservaDTO) throws Exception {
		var resposta = reservarUseCase.execute(reservaDTO);
		return ResponseEntity.ok().body(resposta);
	}
	
	@PostMapping("/atualizar")
	public ResponseEntity<ReservaDTO> atualizarStatusReserva(@RequestBody ReservaDTO reservaDTO) throws Exception {
		var resposta = atualizarStatusReservaUseCase.execute(reservaDTO);
		return ResponseEntity.ok().body(resposta);
	}
	
	@GetMapping("/listar/{idEstabelecimento}")
	public ResponseEntity<List<ReservaDTO>> recuperarReservasPorEstabelecimento(@PathVariable Long idEstabelecimento) throws Exception {
		var resposta = reservasPorEstabelecimentoUseCase.execute(idEstabelecimento);
		return ResponseEntity.ok().body(resposta);
	}
	
	@GetMapping("/listar/{idCliente}")
	public ResponseEntity<List<ReservaDTO>> recuperarReservasPorCliente(@PathVariable Long idCliente) throws Exception {
		var resposta = reservasPorClienteUseCase.execute(idCliente);
		return ResponseEntity.ok().body(resposta);
	}
}
