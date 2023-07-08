package com.martins.helina.adapter.db;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martins.helina.adapter.db.domain.Reserva;
import com.martins.helina.adapter.db.domain.mapper.ReservaMapper;
import com.martins.helina.entrypoint.dto.ReservaDTO;
import com.martins.helina.exceptions.ObjectNotFoundException;
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
				).orElseThrow(() -> new ObjectNotFoundException("O código da reserva não corresponde a nenhuma reserva"));
		
		reserva.setStatusReserva(reservaDTO.getStatusReserva());
		reserva = reservaRepository.save(reserva);
		return ReservaMapper.fromEntityToDTO(reserva);
	}

	@Override
	public List<ReservaDTO> recuperarReservasPorCliente(Long idCliente) throws Exception {
		List<Reserva> lstReserva = reservaRepository.findByIdUsuario(idCliente);
		if(!lstReserva.isEmpty()) {
			return lstReserva.stream().map(ReservaMapper::fromEntityToDTO).collect(Collectors.toList());
		}
		return List.of();
	}

	@Override
	public List<ReservaDTO> recuperarReservasPorEstabelecimento(Long idEstabelecimento) throws Exception {
		List<Reserva> lstReserva = reservaRepository.findByIdEstabelecimento(idEstabelecimento);
		if(!lstReserva.isEmpty()) {
			return lstReserva.stream().map(ReservaMapper::fromEntityToDTO).collect(Collectors.toList());
		}
		return List.of();
	}

}
