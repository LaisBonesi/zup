package br.com.fapen.estoque.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fapen.estoque.models.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

	List<Veiculo> findByIdUsuario(Integer idUsuario);
	
	public Veiculo findByAno(String ano);
	
}