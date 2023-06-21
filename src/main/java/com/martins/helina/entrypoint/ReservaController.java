package com.martins.helina.entrypoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martins.helina.entrypoint.dto.ReservaDTO;
import com.martins.helina.usecase.ReservarUseCase;

@RestController
@RequestMapping("/v1/reservar")
public class ReservaController {
	
	@Autowired
	private ReservarUseCase reservarUseCase;
	
	@PostMapping
	public ResponseEntity<ReservaDTO> reservar(@RequestBody ReservaDTO reservaDTO) throws Exception {
		var resposta = reservarUseCase.execute(reservaDTO);
		return ResponseEntity.ok().body(resposta);
	}
}
