package br.com.fapen.estoque.servicos;

import static java.util.Objects.isNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fapen.estoque.models.Usuario;
import br.com.fapen.estoque.repositorios.UsuarioRepository;
import br.com.fapen.estoque.servicos.exceptions.UsuarioExistenteException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repositorioDeUsuarios;

	public Usuario salvar(Usuario usuario) {
		Usuario existeCpf = repositorioDeUsuarios.findByCpf(usuario.getCpf());
		Usuario existeEmail = repositorioDeUsuarios.findByEmail(usuario.getEmail());

		if (isNull(existeCpf) && isNull(existeEmail)) {
			Usuario usuarioSalvo = repositorioDeUsuarios.save(usuario);
			return usuarioSalvo;
		}else {
			throw new UsuarioExistenteException();
		}
		
	}
}