package com.martins.helina.adapter.db;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
		Optional<Usuario> usuario = repo.findByEmail(email);
		if(usuario.isEmpty()) {
			throw new UsernameNotFoundException(email);
		}
		var perfis = usuario.get().getPerfis().stream()
				.map(x -> 
					Perfil.toEnum(x))
				.collect(Collectors.toSet());
		
		return new UserSS(usuario.get().getId(), usuario.get().getEmail(), usuario.get().getSenha(), perfis);
	}

}
