package br.com.dextra.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.dextra.entity.ProductEntity;

/**
 * Classe de controle dos serviços
 * 
 * @author Rafael Felix de Moraes
 *
 */

@RestController("/item")
@RequestMapping("/")
public class ServicesController {

	// Endereço da API a ser consumida pelos serviços
	private static final String URL = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";
		
		
		/**
		 * Metodo responsavel por chamar o serviço da API e popular uma lista de Produtos
		 * 
		 * @return List<Produto> A lista de produtos populada
		 */
		private List<ProductEntity> callServiceJson() {
			List<ProductEntity> produtos = new ArrayList<ProductEntity>();
			try {
				RestTemplate template = new RestTemplate();
				ResponseEntity<ProductEntity[]> resp = template.getForEntity(URL, ProductEntity[].class);
				produtos = Arrays.asList(resp.getBody());
			} catch(HttpServerErrorException ex) {
				produtos = new ArrayList<ProductEntity>();
			}
			return produtos;
		}
}
