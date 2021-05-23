package br.com.fapen.estoque.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fapen.estoque.models.Usuario;
import br.com.fapen.estoque.models.Veiculo;
import br.com.fapen.estoque.servicos.UsuarioService;
import br.com.fapen.estoque.servicos.VeiculoService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@PostMapping
	public void salvarNoBanco(@Valid @RequestBody Usuario usuario) {
		usuarioService.salvar(usuario);
	}
	
	@GetMapping("/{idUsuario}")
	public List<Veiculo> recuperaVeiculos(@PathVariable("idUsuario") Integer idUsuario) {
		return veiculoService.buscaVeculosUsuario(idUsuario);
	}
	
}