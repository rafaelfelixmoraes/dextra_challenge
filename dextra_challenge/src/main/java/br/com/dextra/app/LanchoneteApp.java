package br.com.dextra.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <strong>Projeto do Desafio Dextra</strong><br><br>
 * 
 * Classe MAIN de execução da aplicação
 * 
 * @author Rafael Felix de Moraes
 *
 */

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.dextra.controller"})
public class LanchoneteApp {

	public static void main(String[] args) {
		SpringApplication.run(LanchoneteApp.class, args);
	}

}
