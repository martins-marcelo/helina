package com.martins.helina.adapter.db;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.martins.helina.adapter.db.domain.Usuario;
import com.martins.helina.adapter.db.domain.mapper.UsuarioMapper;
import com.martins.helina.entrypoint.dto.UsuarioDTO;
import com.martins.helina.exceptions.ObjectNotFoundException;
import com.martins.helina.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UsuarioDBAdapter implements UsuarioDBClient{

	private final UsuarioRepository usuarioRepository;
	
	@Override
	public UsuarioDTO inserirUsuario(UsuarioDTO usuarioDTO) throws Exception{
		Optional<Usuario> usuario = usuarioRepository.findByEmailUsuario(usuarioDTO.getEmailUsuario());
		if(usuario.isPresent())
			throw new Exception("Usuário já cadastrado");
		Usuario usuarioCadastrar = usuarioRepository.save(UsuarioMapper.fromDTOToEntity(usuarioDTO));
		return UsuarioMapper.fromEntityToDTO(usuarioCadastrar);
	}

	@Override
	public UsuarioDTO recuperarDetalhesUsuario(Long idUsuario) throws ObjectNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
		return UsuarioMapper.fromEntityToDTO(usuario.orElseThrow(() -> 
			new ObjectNotFoundException("Usuario não encontrado")));
	}
	

}
