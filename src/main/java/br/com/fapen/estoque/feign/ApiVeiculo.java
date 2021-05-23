package br.com.fapen.estoque.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value ="marcas", url = "https://parallelum.com.br/fipe/api/v1/carros/marcas")

public interface ApiVeiculo {
	
    @RequestMapping(method = RequestMethod.GET, value = "")
    List<Marca> getMarcas();

    @RequestMapping(method = RequestMethod.GET, value = "/{codigoMarca}/modelos")
    Modelos getModelos(@PathVariable("codigoMarca") String codigoMarca);
    
    @RequestMapping(method = RequestMethod.GET, value = "/{codigoMarca}/modelos/{codigoModelo}/anos")
    List<Ano> getAnos(@PathVariable("codigoMarca") String codigoMarca, @PathVariable("codigoModelo") String codigoModelo);
    
}