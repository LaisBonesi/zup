package br.com.fapen.estoque.conversores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LocalDateToStringConverter implements Converter<LocalDate, String> {

	@Override
	public String convert(LocalDate source) {
		
		if (source == null) {
			return "";
		}
		DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return source.format(formatadorDeData);
	}

}
