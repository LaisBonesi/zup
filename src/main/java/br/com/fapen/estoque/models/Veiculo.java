package br.com.fapen.estoque.models;

import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.fapen.estoque.enums.DiaSemanaEnum;

/**
 * @author laisb
 *
 */
@Entity(name = "veiculo")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String marca;
	private String modelo;
	private Integer idUsuario;

	@Column(length = 4)
	private String ano;

	@Enumerated(EnumType.STRING)
	private DiaSemanaEnum rodizio;
	
	private boolean ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean isAtivo() {
		DayOfWeek dataDeHoje = LocalDate.now().getDayOfWeek();
		if (rodizio.getNumeroDia() == dataDeHoje.getValue()) {
			return true;
		} else {
			return false;
		}
	}

	public DiaSemanaEnum getRodizio() {
		return rodizio;
	}

	public void setRodizio(DiaSemanaEnum rodizio) {
		this.rodizio = rodizio;
	}

}
