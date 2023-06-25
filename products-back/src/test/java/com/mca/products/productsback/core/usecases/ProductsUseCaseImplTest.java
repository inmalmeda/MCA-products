package com.mca.products.productsback.core.usecases;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import com.mca.products.core.dto.ProductDetailDTO;
import com.mca.products.core.mappers.ProductsMapper;
import com.mca.products.core.usecases.ProductsUseCaseImpl;
import com.mca.products.exceptions.InvalidDataException;
import com.mca.products.models.ProductDetail;
import com.mca.products.rest.RestClient;

@ExtendWith(MockitoExtension.class)
public class ProductsUseCaseImplTest {
	
	@InjectMocks
	private ProductsUseCaseImpl productsUseCase;
	
	@Mock
	ProductsMapper productsMapper;
	
	@Mock
	RestClient restClient;	
		
	@Test
    public void getProductSimilaReturnExceptionWhenIdNull() { 		
		Assertions.assertThrows(InvalidDataException.class, () -> {
			productsUseCase.getSimilarProduct(null);
		});
    }
	
	@Test
    public void getProductSimilaReturnOk() { 	
				
		ProductDetail productDetail = new ProductDetail();
		productDetail.setId("1");
		productDetail.setName("Product Name");
		productDetail.setPrice(new BigDecimal(25));
		productDetail.availability(true);
		Set<ProductDetail> productToCompare = new HashSet<>();
		productToCompare.add(productDetail);
		
		ProductDetailDTO productDTO = ProductDetailDTO.builder().id("1").name("Product Name").price(new BigDecimal(25)).availability(true).build();
		
		when(restClient.getSimilarProductsIds(Mockito.anyString())).thenReturn(Arrays.asList("1"));
		when(restClient.getProduct(Mockito.anyString())).thenReturn(productDTO);
		when(productsMapper.toProductDetail(Mockito.any())).thenReturn(productDetail);
		
		Set<ProductDetail> products = productsUseCase.getSimilarProduct("1");
		
		assertNotNull(products);
		assertEquals(products, productToCompare);		
    }
}
