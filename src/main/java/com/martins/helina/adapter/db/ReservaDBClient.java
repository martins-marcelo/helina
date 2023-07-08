package com.martins.helina.adapter.db;

import java.util.List;

import com.martins.helina.entrypoint.dto.ReservaDTO;

public interface ReservaDBClient {
	
	ReservaDTO inserirReserva(ReservaDTO reservaDTO) throws Exception;
	
	ReservaDTO atualizarStatusReserva(ReservaDTO reservaDTO) throws Exception;
	
	List<ReservaDTO> recuperarReservasPorCliente(Long idCliente) throws Exception;
	
	List<ReservaDTO> recuperarReservasPorEstabelecimento(Long idEstabelecimento) throws Exception;

}
