package com.mca.products.core.ports;


import java.util.Set;

import com.mca.products.models.ProductDetail;

/**
 * Interface with product use cases
 *
 */
public interface ProductsUseCase {
	
	/**
	 * Gets the similar products from another product identifier
	 * @param productId String with identifier of product
	 * @return A list with the result
	 */
	Set<ProductDetail> getSimilarProduct (String productId);

}
