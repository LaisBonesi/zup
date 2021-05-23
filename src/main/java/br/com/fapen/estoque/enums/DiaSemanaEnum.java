package br.com.fapen.estoque.enums;

public enum DiaSemanaEnum {

	SEGUNDA(1),

	TERCA(2),

	QUARTA(3),

	QUINTA(4),

	SEXTA(5);

	Integer numeroDia;

	DiaSemanaEnum(Integer numeroDia) {
		this.numeroDia = numeroDia;
	}

	public Integer getNumeroDia() {
		return numeroDia;
	}

	public void setNumeroDia(Integer numeroDia) {
		this.numeroDia = numeroDia;
	}

}
