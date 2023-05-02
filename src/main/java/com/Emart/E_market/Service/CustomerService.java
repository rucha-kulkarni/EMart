package com.Emart.E_market.Service;

import com.Emart.E_market.RequestDto.CustomerRequestDto;
import com.Emart.E_market.ResponseDto.CustomerResponseDto;

public interface CustomerService {
    CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto);

    CustomerResponseDto getCustomerById(int id);

    CustomerResponseDto findByEmail(String email);

    CustomerResponseDto findByMobNo(String mobNo);
}