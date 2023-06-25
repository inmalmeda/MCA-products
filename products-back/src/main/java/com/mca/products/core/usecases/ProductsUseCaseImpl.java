package com.mca.products.core.usecases;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mca.products.core.mappers.ProductsMapper;
import com.mca.products.core.ports.ProductsUseCase;
import com.mca.products.exceptions.InvalidDataException;
import com.mca.products.models.ProductDetail;
import com.mca.products.rest.RestClient;

import lombok.extern.slf4j.Slf4j;

/**
 * Use cases for product
 */
@Slf4j
@Service
public class ProductsUseCaseImpl implements ProductsUseCase{
	
	@Autowired
	private RestClient restClient;
	
	@Autowired
	private ProductsMapper productsMapper;
		
	@Override
	public Set<ProductDetail> getSimilarProduct(String productId) {
		
		try {
			log.info(String.format("Searching for similar products of product with id: %s", productId));
			
			//Check that id has value
			if(ObjectUtils.isEmpty(productId)) {
				throw new InvalidDataException("Error due to id value is empty");
			}
			
			//Call rest client to get ids of the products similar to the product 
			List<String> listSimilarProductsIds = restClient.getSimilarProductsIds(productId);
			
			log.info(listSimilarProductsIds.size() + " products similars found: " + listSimilarProductsIds);
				
			return listSimilarProductsIds.stream()
					.map(p -> productsMapper.toProductDetail(restClient.getProduct(p))).collect(Collectors.toSet());					
			
		}catch(Exception e) {
			log.error(String.format("Error searching for similar products: %s", e.getMessage()));
			throw e;
		}		
	}
}
