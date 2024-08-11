package com.iquadras.atalanta;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Atlanta", version = "1", description = "API desenvolvida para o app mobile Iquadras."))
public class AtalantaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtalantaApplication.class, args);
	}

}
