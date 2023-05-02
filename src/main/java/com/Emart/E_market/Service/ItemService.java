package com.Emart.E_market.Service;

import com.Emart.E_market.Exception.ProductNotFoundException;
import com.Emart.E_market.ResponseDto.ItemResponseDto;

public interface ItemService {
    ItemResponseDto viewItem(int productId) throws ProductNotFoundException;
}
