package com.martins.helina.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.martins.helina.controller.dto.EstabelecimentoDTO;
import com.martins.helina.domain.Estabelecimento;
import com.martins.helina.domain.mapper.CronogramaMapper;
import com.martins.helina.domain.mapper.EstabelecimentoMapper;
import com.martins.helina.repository.EstabelecimentoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstabelecimentoService {

    private final EstabelecimentoRepository repository;

    public void criar(EstabelecimentoDTO dto) {
        Estabelecimento e = EstabelecimentoMapper.fromDTOToEntity(dto) ;
        e.setId(UUID.randomUUID().toString());
        repository.save(e);
    }

    public EstabelecimentoDTO atualizar(EstabelecimentoDTO e) {
        var estab =  repository.findById(e.getId());
        estab.setReservaAutomatica(e.getReservaAutomatica());
        estab.setDiasAbertura(CronogramaMapper.fromListDTO(e.getDiasAbertura()));
        estab.setTotalVagas(e.getTotalVagas());
        repository.save(estab);
        return EstabelecimentoMapper.fromEntityToDTO(estab);
    }

    public EstabelecimentoDTO buscarPorId(String id) {
        return EstabelecimentoMapper.fromEntityToDTO(repository.findById(id));
    }

    public List<EstabelecimentoDTO> listarTodos() {
        var estabelecimentos = repository.findAll();
        return estabelecimentos.stream().map(EstabelecimentoMapper::fromEntityToDTO).collect(Collectors.toList());
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }
}
