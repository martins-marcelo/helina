package com.martins.helina.adapter.db;

import com.martins.helina.entrypoint.dto.ReservaDTO;

public interface ReservaDBClient {
	
	ReservaDTO inserirReserva(ReservaDTO reservaDTO) throws Exception;
	
	ReservaDTO atualizarStatusReserva(ReservaDTO reservaDTO) throws Exception;

}
