package br.com.dextra.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

	/**
	 * No Construtor da classe, serão criados em memória os dados que serão usados
	 * no desafio
	 */
	public ServicesController() {
		lanches = new HashMap<Long, ProductEntity>();

		// ------------- Ingredientes dos lanches ---------------------
		IngredientsEntity alface = new IngredientsEntity(1L, "Alface", 0.40);
		IngredientsEntity bacon = new IngredientsEntity(2L, "Bacon", 2.00);
		IngredientsEntity hamburguerCarne = new IngredientsEntity(3L, "Hamburguer de Carne", 3.00);
		IngredientsEntity ovo = new IngredientsEntity(4L, "Ovo", 0.80);
		IngredientsEntity queijo = new IngredientsEntity(5L, "Queijo", 1.50);

		// ------------- Lanches -------------
		// -- X-Bacon
		List<IngredientsEntity> xBaconIngredients = new ArrayList<>();
		xBaconIngredients.add(bacon);
		xBaconIngredients.add(hamburguerCarne);
		xBaconIngredients.add(queijo);
		ProductEntity xBacon = new ProductEntity(1L, "X-Bacon", xBaconIngredients, calcultePrice(xBaconIngredients));

		// -- X-Burguer
		List<IngredientsEntity> xBurguerIngredients = new ArrayList<>();
		xBurguerIngredients.add(hamburguerCarne);
		xBurguerIngredients.add(queijo);
		ProductEntity xBurguer = new ProductEntity(2L, "X-Burguer", xBurguerIngredients,
				calcultePrice(xBurguerIngredients));

		// -- X-Egg
		List<IngredientsEntity> xEggIngredients = new ArrayList<>();
		xEggIngredients.add(ovo);
		xEggIngredients.add(hamburguerCarne);
		xEggIngredients.add(queijo);
		ProductEntity xEgg = new ProductEntity(3L, "X-Egg", xEggIngredients, calcultePrice(xEggIngredients));

		// -- X-Egg Bacon
		List<IngredientsEntity> xEggBaconIngredients = new ArrayList<>();
		xEggBaconIngredients.add(bacon);
		xEggBaconIngredients.add(ovo);
		xEggBaconIngredients.add(hamburguerCarne);
		xEggBaconIngredients.add(queijo);
		ProductEntity xEggBacon = new ProductEntity(4L, "X-Egg Bacon", xEggBaconIngredients, calcultePrice(xEggBaconIngredients));

		// -- X-Salada
		List<IngredientsEntity> xSaladaIngredients = new ArrayList<>();
		xSaladaIngredients.add(alface);
		xSaladaIngredients.add(hamburguerCarne);
		xSaladaIngredients.add(queijo);
		ProductEntity xSalada = new ProductEntity(5L, "X-Salada", xSaladaIngredients, calcultePrice(xSaladaIngredients));

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
	 * @param id
	 *            O ID do lanche
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
	 * Calcula o valor total do lanche a partir dos ingredientes
	 * 
	 * @param ingredients
	 *            A lista de ingredientes
	 * @return O valor total do lanche a partir dos ingredientes
	 */
	private Double calcultePrice(List<IngredientsEntity> ingredients) {
		Double price = 0.0;
		for (IngredientsEntity entity : ingredients) {
			price += entity.getPrice();
		}
		return price;
	}
}
