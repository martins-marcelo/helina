package com.martins.helina.adapter.db;

import java.util.List;

import com.martins.helina.ObjectNotFoundException;
import com.martins.helina.entrypoint.dto.EstabelecimentoDTO;

public interface EstabelecimentoDBClient {
	
	EstabelecimentoDTO recuperarEstabelecimento(Long idEstabelecimento) throws ObjectNotFoundException;
	
	List<EstabelecimentoDTO> listarEstabelecimentos();
	
	EstabelecimentoDTO cadastrarEstabelecimento(EstabelecimentoDTO estabelecimentoDTO);
	
}
