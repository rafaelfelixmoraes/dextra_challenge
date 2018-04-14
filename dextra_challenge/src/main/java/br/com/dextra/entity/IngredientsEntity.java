package br.com.dextra.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade Ingredientes
 * 
 * @author Rafael Felix de Moraes
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientsEntity {

	private Long id;
	private String description;
	private String price;
	private Integer quantity;
	
}
