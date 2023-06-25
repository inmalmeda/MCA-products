package com.mca.products.core.mappers;

import org.mapstruct.Mapper;

import com.mca.products.core.dto.ProductDetailDTO;
import com.mca.products.models.ProductDetail;

/**
 * Mapper for product data
 *
 */
@Mapper(componentModel = "spring")
public interface ProductsMapper {
	
	/**
	 * Convert DTO to ProductDetail
	 * @param productDetailDTO DTO with product data
	 * @return ProductDetail
	 */
	ProductDetail toProductDetail(ProductDetailDTO productDetailDTO);
}
