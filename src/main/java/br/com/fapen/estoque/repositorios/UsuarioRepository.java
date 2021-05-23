package br.com.fapen.estoque.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fapen.estoque.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByEmail(String email);
	
	public Usuario findByCpf(String cpf);

	public Page<Usuario> findByNomeCompletoContainingIgnoreCase(String busca, PageRequest paginacao);
}
