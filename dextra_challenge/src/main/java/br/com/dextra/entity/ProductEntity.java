package br.com.dextra.entity;

import java.util.List;

/**
 * Entidade Produto
 * 
 * @author Rafael Felix de Moraes
 *
 */
public class ProductEntity {
	private Long code; 
	private String description;
	private List<IngredientsEntity> ingredients;
	private Double totalPrice;
	/**
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(Long code) {
		this.code = code;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the ingredients
	 */
	public List<IngredientsEntity> getIngredients() {
		return ingredients;
	}
	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(List<IngredientsEntity> ingredients) {
		this.ingredients = ingredients;
	}
	/**
	 * @return the totalPrice
	 */
	public Double getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
