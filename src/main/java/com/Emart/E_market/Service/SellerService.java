package com.Emart.E_market.Service;

import com.Emart.E_market.Exception.SellerNotFoundException;
import com.Emart.E_market.RequestDto.SellerRequestDto;
import com.Emart.E_market.ResponseDto.ProductResponseDto;
import com.Emart.E_market.ResponseDto.SellerResponseDto;

import java.util.List;

public interface SellerService {

    String addSeller(SellerRequestDto sellerRequestDto) throws Exception;

    List<SellerResponseDto> findAll();

    SellerResponseDto getSellerById(int id) throws SellerNotFoundException;

    List<ProductResponseDto> findProductListBySeller(int id) throws SellerNotFoundException;
}