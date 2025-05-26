package com.martins.helina.adapter.db;

import static com.martins.helina.adapter.db.domain.mapper.EstabelecimentoMapper.fromDTOToEntity;
import static com.martins.helina.adapter.db.domain.mapper.EstabelecimentoMapper.fromEntityToDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.martins.helina.adapter.db.domain.mapper.CardapioMapper;
import com.martins.helina.adapter.db.domain.mapper.CronogramaMapper;
import com.martins.helina.adapter.db.domain.mapper.EnderecoMapper;
import com.martins.helina.adapter.db.domain.mapper.EstabelecimentoMapper;
import com.martins.helina.entrypoint.dto.EstabelecimentoDTO;
import com.martins.helina.exceptions.ObjectNotFoundException;
import com.martins.helina.repository.EstabelecimentoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstabelecimentoDBAdapter implements EstabelecimentoDBClient {

	private final EstabelecimentoRepository estabelecimentoRepository;

	@Override
	public EstabelecimentoDTO recuperarEstabelecimento(Long idEstabelecimento) throws ObjectNotFoundException {
		return fromEntityToDTO(estabelecimentoRepository.findById(idEstabelecimento)
				.orElseThrow(() -> new ObjectNotFoundException("Não foi possível encontrar o estabelecimento")));
	}

	@Override
	public List<EstabelecimentoDTO> listarEstabelecimentos() throws ObjectNotFoundException {
		var estabelecimentos = estabelecimentoRepository.findAll();
		if (estabelecimentos.isEmpty())
			throw new ObjectNotFoundException("Não há estabelecimentos para listar");
		else
			return estabelecimentos.stream().map(EstabelecimentoMapper::fromEntityToDTO).collect(Collectors.toList());
	}

	@Override
	public EstabelecimentoDTO cadastrarEstabelecimento(EstabelecimentoDTO estabelecimentoDTO) {
		var estabelecimento = estabelecimentoRepository.save(fromDTOToEntity(estabelecimentoDTO));
		return fromEntityToDTO(estabelecimento);
	}

	@Override
	public EstabelecimentoDTO atualizarEstabelecimento(EstabelecimentoDTO estabelecimentoDTO) {
		var estabelecimento = estabelecimentoRepository.findById(estabelecimentoDTO.getIdEstabelecimento())
				.orElseThrow(() -> new ObjectNotFoundException("Não foi possível encontrar o estabelecimento"));
		estabelecimento.setCardapio(CardapioMapper.fromDTOToEntity(estabelecimentoDTO.getCardapio()));
		estabelecimento.setDiasAbertura(estabelecimentoDTO.getDiasAbertura().stream()
				.map(CronogramaMapper::fromDTOToEntity)
				.collect(Collectors.toList()));
		estabelecimento.setEndereco(EnderecoMapper.fromDTOToEntity(estabelecimentoDTO.getEndereco()));
		estabelecimento.setTipoReserva(estabelecimentoDTO.getTipoReserva());
		estabelecimento.setTotalVagas(estabelecimentoDTO.getTotalVagas());
		return fromEntityToDTO(estabelecimentoRepository.save(estabelecimento));
	}

}
