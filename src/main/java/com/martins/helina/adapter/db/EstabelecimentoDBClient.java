package com.martins.helina.adapter.db;

import java.util.List;

import com.martins.helina.entrypoint.dto.EstabelecimentoDTO;
import com.martins.helina.exceptions.ObjectNotFoundException;

public interface EstabelecimentoDBClient {
	
	EstabelecimentoDTO recuperarEstabelecimento(Long idEstabelecimento) throws ObjectNotFoundException;
	
	List<EstabelecimentoDTO> listarEstabelecimentos();
	
	EstabelecimentoDTO cadastrarEstabelecimento(EstabelecimentoDTO estabelecimentoDTO);
	
	EstabelecimentoDTO atualizarEstabelecimento(EstabelecimentoDTO estabelecimentoDTO);
	
}
