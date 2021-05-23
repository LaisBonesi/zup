package br.com.fapen.estoque.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fapen.estoque.feign.Ano;
import br.com.fapen.estoque.feign.Marca;
import br.com.fapen.estoque.feign.Modelo;
import br.com.fapen.estoque.models.Veiculo;
import br.com.fapen.estoque.servicos.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping("/marcas")
	public List<Marca> recuperaMarcas(){
		return veiculoService.recuperaMarcas();
	}
	
	@GetMapping("/marcas/{codigoMarca}/modelos")
	public List<Modelo> recuperaModelo(@PathVariable("codigoMarca") String codigoMarca){
		return veiculoService.recuperaModelo(codigoMarca);
	}

	@GetMapping("/marcas/{codigoMarca}/modelos/{codigoModelo}/anos")
	public List<Ano> recuperaAno(@PathVariable("codigoMarca") String codigoMarca, @PathVariable("codigoModelo") String codigoModelo){
		return veiculoService.recuperaAno(codigoMarca, codigoModelo);
	}
	
	@PostMapping
	public void salvarNoBanco(@RequestBody Veiculo veiculo) {
		veiculoService.salvarVeiculo(veiculo);
	}
	
}