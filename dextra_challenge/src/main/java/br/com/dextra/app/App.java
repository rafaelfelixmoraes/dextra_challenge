package br.com.dextra.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Projeto do Desafio Dextra
 * 
 * @author Rafael Felix de Moraes
 *
 */

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.dextra.controller"})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
