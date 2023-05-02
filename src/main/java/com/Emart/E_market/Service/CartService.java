package com.Emart.E_market.Service;

import com.Emart.E_market.Exception.CustomerNotFoundException;
import com.Emart.E_market.RequestDto.OrderRequestDto;
import com.Emart.E_market.ResponseDto.OrderResponseDto;

import java.util.List;

public interface CartService {
    String addToCart(OrderRequestDto orderRequestDto) throws Exception;

    List<OrderResponseDto> checkoutCart(int customerId) throws CustomerNotFoundException;
}
