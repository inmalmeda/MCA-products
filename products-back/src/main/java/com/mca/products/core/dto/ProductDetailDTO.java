package com.mca.products.core.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO of product´s data
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetailDTO {
	
	/**
	 * Product identifier
	 */
	private String id;
	
	/**
	 * Product name
	 */
	private String name;
	
	/**
	 * Product price
	 */
	private BigDecimal price;
	
	/**
	 * Product availability
	 */
	private Boolean availability;

}
