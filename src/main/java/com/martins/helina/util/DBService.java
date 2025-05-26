package com.martins.helina.util;

import java.text.ParseException;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.martins.helina.controller.dto.enums.Perfil;
import com.martins.helina.domain.Endereco;
import com.martins.helina.domain.Usuario;
import com.martins.helina.repository.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private UsuarioRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instantiateTestDatabase() throws ParseException {
		Usuario u0 = Usuario.builder()
				.email("bfmarcelo1@gmail.com")
				.senha(encoder.encode("123"))
				.nome("Celo")
				.endereco(Endereco.builder()
						.cep("689685")
						.cidade("Rio Branco")
						.estado("Acre")
						.complemento("Aculá")
						.rua("Rua do Sol")
						.numero("666A")
						.build())
				.perfis(Set.of(Perfil.ADMIN.getCodigo()))
				.build();
		Optional<Usuario> verify = userRepo.findByEmail(u0.getEmail());
		if(verify.isEmpty())
			userRepo.save(u0);
	}

}
