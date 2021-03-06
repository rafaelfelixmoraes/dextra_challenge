package br.com.dextra.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade Produto
 * 
 * @author Rafael Felix de Moraes
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
	private Long code; 
	private String description;
	private List<IngredientsEntity> ingredients;
	private String totalPrice;

}
