package com.Emart.E_market.Converter;

import com.Emart.E_market.Model.Item;
import com.Emart.E_market.Model.Product;
import com.Emart.E_market.ResponseDto.ItemResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemConverter {
    public static Item productToItem(Product product){
        return Item.builder()
                .requiredQuantity(0)
                .product(product)
                .build();
    }
    public static ItemResponseDto productToItemResponseDto(Product product){
        return ItemResponseDto.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .productCategory(product.getProductCategory())
                .productStatus(product.getProductStatus())
                .build();
    }
}