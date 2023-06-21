package com.martins.helina.adapter.db;

import static com.martins.helina.adapter.db.domain.mapper.EstabelecimentoMapper.fromDTOToEntity;
import static com.martins.helina.adapter.db.domain.mapper.EstabelecimentoMapper.fromEntityToDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.martins.helina.ObjectNotFoundException;
import com.martins.helina.adapter.db.domain.mapper.EstabelecimentoMapper;
import com.martins.helina.entrypoint.dto.EstabelecimentoDTO;
import com.martins.helina.repository.EstabelecimentoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstabelecimentoDBAdapter implements EstabelecimentoDBClient{
	
	private final EstabelecimentoRepository estabelecimentoRepository;

	@Override
	public EstabelecimentoDTO recuperarEstabelecimento(Long idEstabelecimento) throws ObjectNotFoundException {
		return fromEntityToDTO(estabelecimentoRepository.findById(idEstabelecimento).orElseThrow(() -> 
			new ObjectNotFoundException("Não foi possível encontrar o estabelecimento")));
	}

	@Override
	public List<EstabelecimentoDTO> listarEstabelecimentos() throws ObjectNotFoundException{
		var estabelecimentos = estabelecimentoRepository.findAll();
		if(estabelecimentos.isEmpty())
			throw new ObjectNotFoundException("Não há estabelecimentos para listar");
		else
			return estabelecimentos.stream()
					.map(EstabelecimentoMapper::fromEntityToDTO)
					.collect(Collectors.toList());
	}

	@Override
	public EstabelecimentoDTO cadastrarEstabelecimento(EstabelecimentoDTO estabelecimentoDTO) {
		var estabelecimento = estabelecimentoRepository.save(fromDTOToEntity(estabelecimentoDTO));
		return fromEntityToDTO(estabelecimento);
	}

}
