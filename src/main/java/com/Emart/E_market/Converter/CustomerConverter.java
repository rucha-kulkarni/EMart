package com.Emart.E_market.Converter;

import com.Emart.E_market.Model.Customer;
import com.Emart.E_market.RequestDto.CustomerRequestDto;
import com.Emart.E_market.ResponseDto.CustomerResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerConverter {
    public static Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){
        return Customer.builder()
                .name(customerRequestDto.getName())
                .age(customerRequestDto.getAge())
                .mobNo(customerRequestDto.getMobNo())
                .email(customerRequestDto.getEmail())
                .build();
    }
    public static CustomerResponseDto customerToCustomerResponseDto(Customer customer){
        return CustomerResponseDto.builder()
                .email(customer.getEmail())
                .name(customer.getName())
                .mobNo(customer.getMobNo())
                .build();
    }
}