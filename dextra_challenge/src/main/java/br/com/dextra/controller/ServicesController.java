package br.com.dextra.controller;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dextra.entity.IngredientsEntity;
import br.com.dextra.entity.ProductEntity;

/**
 * Classe de controle dos serviços
 * 
 * @author Rafael Felix de Moraes
 *
 */

@RestController
@RequestMapping(value = "/lanches")
public class ServicesController {

	private Map<Long, ProductEntity> lanches;
	private static DecimalFormat df = new DecimalFormat("#0.00#", new DecimalFormatSymbols(Locale.US));

	/**
	 * No Construtor da classe, serão criados em memória os dados que serão usados
	 * no desafio
	 */
	public ServicesController() {
		lanches = new HashMap<Long, ProductEntity>();

		// ------------- Ingredientes dos lanches ---------------------
		IngredientsEntity alface = new IngredientsEntity(1L, "Alface", df.format(0.40), 1);
		IngredientsEntity bacon = new IngredientsEntity(2L, "Bacon", df.format(2.00), 1);
		IngredientsEntity hamburguerCarne = new IngredientsEntity(3L, "Hamburguer de Carne", df.format(3.00), 1);
		IngredientsEntity ovo = new IngredientsEntity(4L, "Ovo", df.format(0.80), 1);
		IngredientsEntity queijo = new IngredientsEntity(5L, "Queijo", df.format(1.50), 1 );

		// ------------- Lanches -------------
		// -- X-Bacon
		List<IngredientsEntity> xBaconIngredients = new ArrayList<>();
		xBaconIngredients.add(bacon);
		xBaconIngredients.add(hamburguerCarne);
		xBaconIngredients.add(queijo);
		ProductEntity xBacon = new ProductEntity(1L, "X-Bacon", xBaconIngredients, df.format(calcultePrice(xBaconIngredients)));

		// -- X-Burguer
		List<IngredientsEntity> xBurguerIngredients = new ArrayList<>();
		xBurguerIngredients.add(hamburguerCarne);
		xBurguerIngredients.add(queijo);
		ProductEntity xBurguer = new ProductEntity(2L, "X-Burguer", xBurguerIngredients, df.format(calcultePrice(xBurguerIngredients)));

		// -- X-Egg
		List<IngredientsEntity> xEggIngredients = new ArrayList<>();
		xEggIngredients.add(ovo);
		xEggIngredients.add(hamburguerCarne);
		xEggIngredients.add(queijo);
		ProductEntity xEgg = new ProductEntity(3L, "X-Egg", xEggIngredients, df.format(calcultePrice(xEggIngredients)));

		// -- X-Egg Bacon
		List<IngredientsEntity> xEggBaconIngredients = new ArrayList<>();
		xEggBaconIngredients.add(bacon);
		xEggBaconIngredients.add(ovo);
		xEggBaconIngredients.add(hamburguerCarne);
		xEggBaconIngredients.add(queijo);
		ProductEntity xEggBacon = new ProductEntity(4L, "X-Egg Bacon", xEggBaconIngredients, df.format(calcultePrice(xEggBaconIngredients)));

		// -- X-Salada
		List<IngredientsEntity> xSaladaIngredients = new ArrayList<>();
		xSaladaIngredients.add(alface);
		xSaladaIngredients.add(hamburguerCarne);
		xSaladaIngredients.add(queijo);
		ProductEntity xSalada = new ProductEntity(5L, "X-Salada", xSaladaIngredients, df.format(calcultePrice(xSaladaIngredients)));

		lanches.put(1L, xBacon);
		lanches.put(2L, xBurguer);
		lanches.put(3L, xEgg);
		lanches.put(4L, xEggBacon);
		lanches.put(5L, xSalada);
	}

	/**
	 * Serviço Rest que retorna a lista dos Lanches que estão na memória
	 * 
	 * @return Uma lista de {@link ProductEntity} armazenada em memória
	 */
	@RequestMapping(value = "/cardapio", method = RequestMethod.GET)
	public ResponseEntity<List<ProductEntity>> listar() {
		return new ResponseEntity<List<ProductEntity>>(new ArrayList<ProductEntity>(lanches.values()), HttpStatus.OK);
	}

	/**
	 * Serviço que retorna um Lanche a partir do seu ID
	 * 
	 * @param id O ID do lanche
	 * @return Um objetivo do tipo {@link ProductEntity} armazenado em memória
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductEntity> buscar(@PathVariable("id") Long id) {
		ProductEntity lanche = lanches.get(id);

		if (lanche == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ProductEntity>(lanche, HttpStatus.OK);
	}
	
	/**
	 * Serviço que retorna o lanche personalizado de acordo com os ingredientes adicionados
	 * @param id O Id do lanche no cardapio
	 * @param ingredients A lista de ingredientes do lanche
	 * @return Um objetivo do tipo {@link ProductEntity} armazenado em memória
	 */
	@RequestMapping(value = "/{id}/personalizado", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ProductEntity> custom(@PathVariable("id") Long id, @RequestBody List<IngredientsEntity> ingredients) {
		ProductEntity lanche = lanches.get(id);
		lanche.setIngredients(ingredients);
		List<IngredientsEntity> newIngredients = lanche.getIngredients();
		lanche.setTotalPrice(df.format(calcultePrice(newIngredients)));
		
		return new ResponseEntity<ProductEntity>(lanche, HttpStatus.OK);
	}

	/**
	 * Calcula o valor total do lanche a partir dos ingredientes
	 * 
	 * @param ingredients  A lista de ingredientes
	 * @return O valor total do lanche a partir dos ingredientes
	 */
	private Double calcultePrice(List<IngredientsEntity> ingredients) {
		Double price = 0.00;
		Double total = 0.00;
		for (IngredientsEntity entity : ingredients) {
			price = Double.parseDouble(entity.getPrice()) * entity.getQuantity();
			total += price;
		}
		return total;
	}
}
