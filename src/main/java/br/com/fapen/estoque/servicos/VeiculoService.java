package br.com.fapen.estoque.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fapen.estoque.enums.DiaSemanaEnum;
import br.com.fapen.estoque.feign.Ano;
import br.com.fapen.estoque.feign.ApiVeiculo;
import br.com.fapen.estoque.feign.Marca;
import br.com.fapen.estoque.feign.Modelo;
import br.com.fapen.estoque.feign.Modelos;
import br.com.fapen.estoque.models.Veiculo;
import br.com.fapen.estoque.repositorios.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private ApiVeiculo apiVeiculo;

	public List<Marca> recuperaMarcas() {
		return apiVeiculo.getMarcas();
	}

	public List<Modelo> recuperaModelo(String codigoMarca) {
		Modelos modelos = apiVeiculo.getModelos(codigoMarca);

		return modelos.getModelos();
	}

	public List<Ano> recuperaAno(String codigoMarca, String codigoModelo) {
		return apiVeiculo.getAnos(codigoMarca, codigoModelo);
	}
	

	public void salvarVeiculo(Veiculo veiculo) {
		DiaSemanaEnum diaRodizio = recuperaDiaRodizio(veiculo.getAno());
		veiculo.setRodizio(diaRodizio);
		veiculoRepository.save(veiculo);
	}
	
	public List<Veiculo> buscaVeculosUsuario(Integer idUsuario){
		List<Veiculo> listVeiculos = veiculoRepository.findByIdUsuario(idUsuario);
		return listVeiculos;
	}

	private DiaSemanaEnum recuperaDiaRodizio(String ano) {
		String ultimo = ano.substring(ano.length() - 3, ano.length() - 2);

		if (ultimo.equals("0") || ultimo.equals("1")) {
			return DiaSemanaEnum.SEGUNDA;
		} else if (ultimo.equals("2") || ultimo.equals("3")) {
			return DiaSemanaEnum.TERCA;
		} else if (ultimo.equals("4") || ultimo.equals("5")) {
			return DiaSemanaEnum.QUARTA;
		} else if (ultimo.equals("6") || ultimo.equals("7")) {
			return DiaSemanaEnum.QUINTA;
		} else if (ultimo.equals("8") || ultimo.equals("9")) {
			return DiaSemanaEnum.SEXTA;
		}
		return null;
	}
}