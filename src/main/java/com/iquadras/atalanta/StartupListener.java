package com.iquadras.atalanta;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StartupListener implements ApplicationListener<ApplicationStartedEvent> {

  @Override
  public void onApplicationEvent(ApplicationStartedEvent event) {
    String address = "localhost"; // Alterar se você estiver usando um endereço IP diferente
    int port = event.getApplicationContext().getEnvironment().getProperty("local.server.port", Integer.class, 8080);
    System.out.println("\nA aplicação está rodando em: http://" + address + ":" + port);
  }
}
