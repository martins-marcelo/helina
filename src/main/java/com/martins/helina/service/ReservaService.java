package com.martins.helina.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.martins.helina.controller.dto.ReservaDTO;
import com.martins.helina.controller.dto.enums.StatusReservaEnum;
import com.martins.helina.domain.Reserva;
import com.martins.helina.domain.mapper.ReservaMapper;
import com.martins.helina.repository.ReservaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository repository;

    public Boolean atualizarStatusReserva(ReservaDTO dto) throws Exception {
        Optional<Reserva> r = repository.findById(dto.getIdReserva());
        if(r.isEmpty() || r.get().getStatus() == StatusReservaEnum.CANCELADA.name()) {
            return false;
        }
        return true;
    }

    public void criar(ReservaDTO dto) {
        Reserva r = ReservaMapper.fromDTOToEntity(dto);
        r.setIdReserva(UUID.randomUUID().toString());
        repository.save(r);
    }

    public List<ReservaDTO> buscarReservasPorIdUsuario(String idUsuario) throws Exception {
        List<Reserva> reservas = repository.findByIdUsuario(idUsuario);
        if(!reservas.isEmpty()) {
            return reservas.stream().map(ReservaMapper::fromEntityToDTO).collect(Collectors.toList());
        }
        throw new Exception("Não foram encontradas reservas para este usuario");
    }

    public List<ReservaDTO> buscarReservasPorIdEstabelecimento(String idEstabelecimento) throws Exception {
        List<Reserva> reservas = repository.findByIdEstabelecimento(idEstabelecimento);
        if(!reservas.isEmpty()) {
            return reservas.stream().map(ReservaMapper::fromEntityToDTO).collect(Collectors.toList());
        }
        throw new Exception("Não foram encontradas reservas neste estabelecimento");
    }
    
}
