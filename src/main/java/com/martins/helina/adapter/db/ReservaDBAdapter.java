package com.martins.helina.adapter.db;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martins.helina.adapter.db.domain.Reserva;
import com.martins.helina.adapter.db.domain.mapper.ReservaMapper;
import com.martins.helina.entrypoint.dto.ReservaDTO;
import com.martins.helina.repository.ReservaRepository;

@Service
public class ReservaDBAdapter implements ReservaDBClient{
	
	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	public ReservaDTO inserirReserva(ReservaDTO reservaDTO) throws Exception {
		reservaDTO.setIdReserva(null);
		Reserva reserva = reservaRepository.save(ReservaMapper.fromDTOToEntity(reservaDTO));
		return ReservaMapper.fromEntityToDTO(reserva);
	}

	@Override
	public ReservaDTO atualizarStatusReserva(ReservaDTO reservaDTO) throws Exception {
		Reserva reserva = reservaRepository.findById(Optional
					.ofNullable(reservaDTO.getIdReserva()).orElseThrow(() -> new Exception("A reserva não possui código"))
				).orElseThrow(() -> new Exception("O código da reserva não corresponde a nenhuma reserva"));
		
//		reserva.setStatusReserva(reservaDTO.getStatusReserva());
		reserva = reservaRepository.save(reserva);
		return ReservaMapper.fromEntityToDTO(reserva);
	}

}
