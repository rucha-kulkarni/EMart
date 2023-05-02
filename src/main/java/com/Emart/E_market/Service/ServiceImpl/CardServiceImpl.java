package com.Emart.E_market.Service.ServiceImpl;

import com.Emart.E_market.Converter.CardConverter;
import com.Emart.E_market.Exception.CustomerNotFoundException;
import com.Emart.E_market.Model.Card;
import com.Emart.E_market.Model.Customer;
import com.Emart.E_market.Repository.CardRepository;
import com.Emart.E_market.Repository.CustomerRepository;
import com.Emart.E_market.RequestDto.CardRequestDto;
import com.Emart.E_market.ResponseDto.CardDto;
import com.Emart.E_market.ResponseDto.CardResponseDto;
import com.Emart.E_market.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CustomerRepository customerRepository1;

    @Autowired
    CardRepository cardRepository;


    @Override
    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException {
        Customer customer;
        try {
            customer = customerRepository1.findById(cardRequestDto.getCustomerId()).get();
        }
        catch (Exception e){
            throw new CustomerNotFoundException("Customer Not Found!!");
        }
        Card card = CardConverter.cardRequestDtoToCard(cardRequestDto);
        card.setCustomer(customer);
        customer.getCards().add(card);

        customerRepository1.save(customer);

        // prepare Response Dto
        CardResponseDto cardResponseDto = new CardResponseDto();
        cardResponseDto.setName(customer.getName());

        // convert every card to cardDto
        List<CardDto> cardDtoList = new ArrayList<>();
        for(Card card1: customer.getCards()){
            CardDto cardDto = new CardDto();
            cardDto.setCardNo(card1.getCardNo());
            cardDto.setCardType(card1.getCardType());

            cardDtoList.add(cardDto);
        }

        cardResponseDto.setCardDtos(cardDtoList);
        return cardResponseDto;
    }


}