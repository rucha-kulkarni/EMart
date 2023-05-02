package com.Emart.E_market.Converter;


import com.Emart.E_market.Model.Card;
import com.Emart.E_market.RequestDto.CardRequestDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CardConverter {
    public static Card cardRequestDtoToCard(CardRequestDto cardRequestDto){
        return Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cardType(cardRequestDto.getCardType())
                .cvv(cardRequestDto.getCvv())
                .build();
    }
}