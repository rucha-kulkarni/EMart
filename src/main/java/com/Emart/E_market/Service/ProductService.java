package com.Emart.E_market.Service;

import com.Emart.E_market.Enum.ProductCategory;
import com.Emart.E_market.Enum.ProductStatus;
import com.Emart.E_market.Exception.SellerNotFoundException;
import com.Emart.E_market.RequestDto.ProductRequestDto;
import com.Emart.E_market.ResponseDto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException;

    List<ProductResponseDto> getAllProductByCategory(ProductCategory productCategory);

    List<ProductResponseDto> getAllProductByStatus(ProductStatus productStatus);

    ProductResponseDto updateProductCategory(ProductRequestDto productRequestDto);
}