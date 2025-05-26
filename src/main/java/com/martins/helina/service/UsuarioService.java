package com.martins.helina.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.martins.helina.controller.dto.UsuarioDTO;
import com.martins.helina.controller.dto.enums.Perfil;
import com.martins.helina.domain.Usuario;
import com.martins.helina.domain.mapper.UsuarioMapper;
import com.martins.helina.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    
    public Boolean isUsuarioCliente(String idUsuario) {
        var usuario = repository.findById(idUsuario);
        if(usuario.getPerfis().contains(Perfil.CLIENTE_USER.getCodigo())){
            return true;
        }
        return false;
    }

    public void criar(UsuarioDTO dto) throws Exception {
        Optional<Usuario> u = repository.findByEmail(dto.getEmail());
        if(u.isPresent())
            throw new Exception("Email já cadastrado");
        var usuario = UsuarioMapper.fromDTOToEntity(dto);
        usuario.setId(null);
        repository.save(usuario);
    }

    public UsuarioDTO buscarPorId(String id) {
        return UsuarioMapper.fromEntityToDTO(repository.findById(id));
    }
}
