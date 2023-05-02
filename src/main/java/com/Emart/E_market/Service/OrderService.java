package com.Emart.E_market.Service;

import com.Emart.E_market.RequestDto.OrderRequestDto;
import com.Emart.E_market.ResponseDto.OrderResponseDto;

public interface OrderService {
    OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws Exception;
}