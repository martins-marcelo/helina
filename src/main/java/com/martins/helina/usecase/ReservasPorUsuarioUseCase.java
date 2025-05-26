package com.martins.helina.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import com.martins.helina.controller.dto.ReservaDTO;
import com.martins.helina.controller.dto.UsuarioDTO;
import com.martins.helina.service.ReservaService;
import com.martins.helina.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReservasPorUsuarioUseCase {

	private final UsuarioService usuarioService;
	private final ReservaService reservaService;

	
	public List<ReservaDTO> execute(String idUsuario) throws Exception{
		
		UsuarioDTO usuario = usuarioService.buscarPorId(idUsuario);
		if(usuario != null)
			return reservaService.buscarReservasPorIdUsuario(idUsuario);
		return null;
		
	}

}
