package com.mca.products.adapters.entrypoints;

import java.util.Set;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.mca.products.controllers.ProductApi;
import com.mca.products.core.ports.ProductsUseCase;
import com.mca.products.models.ProductDetail;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller to manage products
 * @author Inmaculada C. Jiménez Almeda
 *
 */
@Slf4j
@RestController
public class ProductsController implements ProductApi {
	
	@Autowired
	private ProductsUseCase productsUseCase;
	
	@Override
	public ResponseEntity<Set<ProductDetail>> getProductSimilar(String productId) {
	
		log.info(String.format("Get similar products of product with id: %s", productId));
		
		try {	
			
			Set<ProductDetail> productsSimilar = productsUseCase.getSimilarProduct(productId);			
			return !ObjectUtils.isEmpty(productsSimilar) ?  ResponseEntity.ok(productsSimilar) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
			
		}catch(Exception e) {				
			throw e;
		}finally {
			log.info(String.format("End of getting similar products of product with id: %s", productId));
		}			
	}
}
