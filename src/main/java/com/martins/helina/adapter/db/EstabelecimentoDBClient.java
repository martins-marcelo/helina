package com.martins.helina.adapter.db;

import java.util.List;

import com.martins.helina.controller.dto.EstabelecimentoDTO;
import com.martins.helina.exception.ObjectNotFoundException;

public interface EstabelecimentoDBClient {
	
	EstabelecimentoDTO recuperarEstabelecimento(Long idEstabelecimento) throws ObjectNotFoundException;
	
	List<EstabelecimentoDTO> listarEstabelecimentos();
	
	EstabelecimentoDTO cadastrarEstabelecimento(EstabelecimentoDTO estabelecimentoDTO);
	
	EstabelecimentoDTO atualizarEstabelecimento(EstabelecimentoDTO estabelecimentoDTO);
	
}
