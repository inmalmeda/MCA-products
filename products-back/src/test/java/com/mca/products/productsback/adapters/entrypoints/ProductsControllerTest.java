package com.mca.products.productsback.adapters.entrypoints;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.mca.products.adapters.entrypoints.ProductsController;
import com.mca.products.core.ports.ProductsUseCase;
import com.mca.products.models.ProductDetail;

@ExtendWith(MockitoExtension.class)
public class ProductsControllerTest {
	
    @InjectMocks
    ProductsController productsController;
    
    @Mock
    ProductsUseCase productsUseCase;
    
    @Test
    public void getProductSimilarReturnNotFound() {    	
    	ResponseEntity<Set<ProductDetail>> responseGet = productsController.getProductSimilar("1");
    	assertThat(responseGet.getStatusCodeValue()).isEqualTo(404);
    }
    
    @Test
    public void getProductSimilarReturnOk() {  
    	ProductDetail productDetail = new ProductDetail();
		productDetail.setId("1");
		productDetail.setName("Product Name");
		productDetail.setPrice(new BigDecimal(25));
		productDetail.availability(true);
		Set<ProductDetail> products = new HashSet<>();
		products.add(productDetail);

    	when(productsUseCase.getSimilarProduct(Mockito.anyString())).thenReturn(products);
    	
    	ResponseEntity<Set<ProductDetail>> responseGet = productsController.getProductSimilar("1");
    	assertThat(responseGet.getStatusCodeValue()).isEqualTo(200);
    }
}
