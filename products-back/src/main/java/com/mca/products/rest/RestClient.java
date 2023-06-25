package com.mca.products.rest;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mca.products.core.dto.ProductDetailDTO;

/**
 * Interface to call rest client
 *
 */
@FeignClient(value="sasapi", url="${rest.url}", configuration=FeignClientConfiguration.class)
public interface RestClient {
	
	/**
	 * Gets a list with the ids of products similar to another
	 * @param productId Product identifier
	 * @return List with the result
	 */
	@GetMapping("/product/{productId}/similarids")
	public List<String> getSimilarProductsIds(@PathVariable String productId);
	
	/**
	 * Gets a product by an id
	 * @param productId Product identifier
	 * @return DTO of the product found
	 */
	@GetMapping("/product/{productId}")
	public ProductDetailDTO getProduct(@PathVariable String productId);
}
