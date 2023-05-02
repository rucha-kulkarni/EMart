package com.Emart.E_market.Converter;


import com.Emart.E_market.Enum.ProductStatus;
import com.Emart.E_market.Model.Product;
import com.Emart.E_market.RequestDto.ProductRequestDto;
import com.Emart.E_market.ResponseDto.ProductResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductConverter {
    public static ProductResponseDto productToProductResponseDto(Product product){
        return ProductResponseDto.builder()
                .productName(product.getProductName())
                .productStatus(product.getProductStatus())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }
    public static Product productRequestDtoToProduct(ProductRequestDto productRequestDto){
        return Product.builder()
                .productName(productRequestDto.getProductName())
                .price(productRequestDto.getPrice())
                .quantity(productRequestDto.getQuantity())
                .productCategory(productRequestDto.getProductCategory())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }
}