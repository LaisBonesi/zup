package br.com.fapen.estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
@EnableFeignClients
public class EstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoqueApplication.class, args);
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource resource = 
			new ReloadableResourceBundleMessageSource();

		resource.setBasename("classpath:messages");	
		resource.setDefaultEncoding("UTF-8");
		resource.setCacheSeconds(1);
		return resource;
	}
	
}
