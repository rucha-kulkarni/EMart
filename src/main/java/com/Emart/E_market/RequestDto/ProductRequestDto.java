package com.Emart.E_market.RequestDto;

import com.Emart.E_market.Enum.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    private String productName;

    private int price;

    private int quantity;

    private ProductCategory productCategory;

    private int sellerId;

}
