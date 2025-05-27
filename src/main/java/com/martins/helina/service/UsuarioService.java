package com.martins.helina.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private final BCryptPasswordEncoder encoder;
    
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
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        usuario.setId(UUID.randomUUID().toString());
        repository.save(usuario);
    }

    public UsuarioDTO buscarPorId(String id) {
        return UsuarioMapper.fromEntityToDTO(repository.findById(id));
    }
}
