package com.Emart.E_market.ResponseDto;

import com.Emart.E_market.Enum.ProductCategory;
import com.Emart.E_market.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemResponseDto {
    private String productName;

    private int price;

    private ProductCategory productCategory;

    private ProductStatus productStatus;
}
