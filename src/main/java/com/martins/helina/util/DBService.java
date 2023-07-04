package com.martins.helina.util;

import java.text.ParseException;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.martins.helina.adapter.db.domain.Endereco;
import com.martins.helina.adapter.db.domain.Usuario;
import com.martins.helina.entrypoint.dto.enums.Perfil;
import com.martins.helina.repository.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private UsuarioRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instantiateTestDatabase() throws ParseException {
		Usuario u0 = Usuario.builder()
				.emailUsuario("bfmarcelo1@gmail.com")
				.senhaUsuario(encoder.encode("123"))
				.nomeUsuario("Celo")
				.endereco(Endereco.builder()
						.cep("689685")
						.cidade("Rio Branco")
						.estado("Acre")
						.complemento("Aculá")
						.logradouro("Rua do Sol")
						.numero("666A")
						.build())
				.perfis(Set.of(Perfil.ADMIN.getCodigo()))
				.build();
		Optional<Usuario> verify = userRepo.findByEmailUsuario(u0.getEmailUsuario());
		if(verify.isEmpty())
			userRepo.save(u0);
	}

}
