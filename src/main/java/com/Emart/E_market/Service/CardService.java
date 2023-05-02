package com.Emart.E_market.Service;

import com.Emart.E_market.Exception.CustomerNotFoundException;
import com.Emart.E_market.RequestDto.CardRequestDto;
import com.Emart.E_market.ResponseDto.CardResponseDto;

public interface CardService {
    CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException;
}
