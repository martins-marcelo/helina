package com.martins.helina.adapter.db;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.martins.helina.controller.dto.enums.Perfil;
import com.martins.helina.domain.Usuario;
import com.martins.helina.repository.UsuarioRepository;
import com.martins.helina.security.UserSS;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final UsuarioRepository repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = repo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com email: " + email));
		
		Set<Perfil> perfis = Optional.ofNullable(usuario.getPerfis())
                .orElse(Set.of())
                .stream()
                .map(Perfil::toEnum)
                .collect(Collectors.toSet());
		
		return new UserSS(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getSenha(),
                perfis
        );
	}

}
