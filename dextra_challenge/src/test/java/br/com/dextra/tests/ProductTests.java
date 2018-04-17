package br.com.dextra.tests;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

import br.com.dextra.controller.ServicesController;
import br.com.dextra.entity.IngredientsEntity;
import br.com.dextra.entity.ProductEntity;

/**
 * Classe de Testes Unitários para validar os pontos solicitados no desafio
 * 
 * @author Rafael Felix de Moraes
 *
 */
public class ProductTests {
	private ServicesController servicesController;
	private DecimalFormat df;

	@Before
	public void setUp() throws Exception {
		servicesController = new ServicesController();
		df = new DecimalFormat("#0.00#", new DecimalFormatSymbols(Locale.US));
	}

	@Test
	public void cardapioTest() {
		IngredientsEntity bacon;
		IngredientsEntity hamburguerCarne;
		IngredientsEntity ovo;
		IngredientsEntity queijo;

		// ------------- Ingredientes dos lanches ---------------------
		bacon = new IngredientsEntity(2L, "Bacon", df.format(2.00), 1);
		hamburguerCarne = new IngredientsEntity(3L, "Hamburguer de Carne", df.format(3.00), 1);
		ovo = new IngredientsEntity(4L, "Ovo", df.format(0.80), 1);
		queijo = new IngredientsEntity(5L, "Queijo", df.format(1.50), 1);

		// ------------- Lanches -------------
		// -- X-Bacon
		List<IngredientsEntity> xBaconIngredients = new ArrayList<>();
		xBaconIngredients.add(bacon);
		xBaconIngredients.add(hamburguerCarne);
		xBaconIngredients.add(queijo);
		ProductEntity xBacon = new ProductEntity(1L, "X-Bacon", xBaconIngredients, df.format(servicesController.calcultePrice(xBaconIngredients)));

		// -- X-Burguer
		List<IngredientsEntity> xBurguerIngredients = new ArrayList<>();
		xBurguerIngredients.add(hamburguerCarne);
		xBurguerIngredients.add(queijo);
		ProductEntity xBurguer = new ProductEntity(2L, "X-Burguer", xBurguerIngredients, df.format(servicesController.calcultePrice(xBurguerIngredients)));

		// -- X-Egg
		List<IngredientsEntity> xEggIngredients = new ArrayList<>();
		xEggIngredients.add(ovo);
		xEggIngredients.add(hamburguerCarne);
		xEggIngredients.add(queijo);
		ProductEntity xEgg = new ProductEntity(3L, "X-Egg", xEggIngredients, df.format(servicesController.calcultePrice(xEggIngredients)));

		// -- X-Egg Bacon
		List<IngredientsEntity> xEggBaconIngredients = new ArrayList<>();
		xEggBaconIngredients.add(bacon);
		xEggBaconIngredients.add(ovo);
		xEggBaconIngredients.add(hamburguerCarne);
		xEggBaconIngredients.add(queijo);
		ProductEntity xEggBacon = new ProductEntity(4L, "X-Egg Bacon", xEggBaconIngredients, df.format(servicesController.calcultePrice(xEggBaconIngredients)));

		assertEquals("6.50", xBacon.getTotalPrice());
		assertEquals("4.50", xBurguer.getTotalPrice());
		assertEquals("5.30", xEgg.getTotalPrice());
		assertEquals("7.30", xEggBacon.getTotalPrice());
	}

	@Test
	public void promocaoLightTest() {
		IngredientsEntity hamburguerCarne;
		IngredientsEntity queijo;
		IngredientsEntity alface;

		// ------------- Ingredientes do Lanche ---------------------
		alface = new IngredientsEntity(1L, "Alface", df.format(0.40), 1);
		hamburguerCarne = new IngredientsEntity(3L, "Hamburguer de Carne", df.format(3.00), 1);
		queijo = new IngredientsEntity(5L, "Queijo", df.format(1.50), 1);

		// -- X-Salada
		List<IngredientsEntity> xSaladaIngredients = new ArrayList<>();
		xSaladaIngredients.add(alface);
		xSaladaIngredients.add(hamburguerCarne);
		xSaladaIngredients.add(queijo);
		ProductEntity xSalada = new ProductEntity(5L, "X-Salada", xSaladaIngredients, df.format(servicesController.calcultePrice(xSaladaIngredients)));
		
		assertEquals("4.41", xSalada.getTotalPrice());
	}
	
	@Test
	public void promocaoMuitaCarneTest() {
		IngredientsEntity bacon;
		IngredientsEntity hamburguerCarne;
		IngredientsEntity queijo;
		
		// ------------- Ingredientes dos lanche ---------------------
		bacon = new IngredientsEntity(2L, "Bacon", df.format(2.00), 1);
		hamburguerCarne = new IngredientsEntity(3L, "Hamburguer de Carne", df.format(3.00), 6);
		queijo = new IngredientsEntity(5L, "Queijo", df.format(1.50), 1);
		
		// -- X-Egg Bacon Personalizado
		List<IngredientsEntity> xEggBaconIngredients = new ArrayList<>();
		xEggBaconIngredients.add(bacon);
		xEggBaconIngredients.add(hamburguerCarne);
		xEggBaconIngredients.add(queijo);
		ProductEntity xBacon = new ProductEntity(4L, "X-Egg Bacon Promoção", xEggBaconIngredients, df.format(servicesController.calcultePrice(xEggBaconIngredients)));
		
		assertEquals("15.50", xBacon.getTotalPrice());
	}
	
	@Test
	public void promocaoMuitoQueijoTest() {
		IngredientsEntity hamburguerCarne;
		IngredientsEntity queijo;
		
		// ------------- Ingredientes dos lanches ---------------------
		hamburguerCarne = new IngredientsEntity(3L, "Hamburguer de Carne", df.format(3.00), 1);
		queijo = new IngredientsEntity(5L, "Queijo", df.format(1.50), 3);
		
		// -- X-Burguer Personalizado
		List<IngredientsEntity> xBurguerIngredients = new ArrayList<>();
		xBurguerIngredients.add(hamburguerCarne);
		xBurguerIngredients.add(queijo);
		ProductEntity xBurguer = new ProductEntity(2L, "X-Burguer Promoção", xBurguerIngredients, df.format(servicesController.calcultePrice(xBurguerIngredients)));
		
		assertEquals("6.00", xBurguer.getTotalPrice());
	}
	
	@Test
	public void lanchePersonalizadoTest() {
		IngredientsEntity bacon;
		IngredientsEntity hamburguerCarne;
		IngredientsEntity queijo;
		IngredientsEntity ovo;
		IngredientsEntity alface;
		
		// ------------- Ingredientes dos lanche ---------------------
		alface = new IngredientsEntity(1L, "Alface", df.format(0.40), 1);
		bacon = new IngredientsEntity(2L, "Bacon", df.format(2.00), 2);
		hamburguerCarne = new IngredientsEntity(3L, "Hamburguer de Carne", df.format(3.00), 2);
		ovo = new IngredientsEntity(4L, "Ovo", df.format(0.80), 1);
		queijo = new IngredientsEntity(5L, "Queijo", df.format(1.50), 1 );
		
		// -- Lanche Personalizado
		List<IngredientsEntity> xCustomIngredients = new ArrayList<>();
		xCustomIngredients.add(bacon);
		xCustomIngredients.add(hamburguerCarne);
		xCustomIngredients.add(queijo);
		xCustomIngredients.add(ovo);
		xCustomIngredients.add(alface);
		ProductEntity xCustomLanche = new ProductEntity(99L, "Lanche Personalizado", xCustomIngredients, df.format(servicesController.calcultePrice(xCustomIngredients)));
		
		assertEquals("12.70", xCustomLanche.getTotalPrice());
	}

}
