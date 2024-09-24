package com.iquadras.atalanta;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("/**") // Permite todas as rotas
        .allowedOriginPatterns("*") // Permite todas as origens com padrões
        .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
        .allowedHeaders("*") // Permite todos os headers
        .allowCredentials(true); // Permite o envio de cookies ou credenciais
  }
}