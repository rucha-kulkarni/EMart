package com.Emart.E_market.Converter;

import com.Emart.E_market.Model.Seller;
import com.Emart.E_market.RequestDto.SellerRequestDto;
import com.Emart.E_market.ResponseDto.SellerResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SellerConverter {
    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){
        return Seller.builder()
                .name(sellerRequestDto.getName())
                .email(sellerRequestDto.getEmail())
                .mobNo(sellerRequestDto.getMobNo())
                .panNo(sellerRequestDto.getPanNo())
                .build();
    }
    public static SellerResponseDto sellerToSellerResponseDto(Seller seller){
        return SellerResponseDto.builder()
                .name(seller.getName())
                .email(seller.getEmail())
                .mobNo(seller.getMobNo())
                .panNo(seller.getPanNo())
                .build();
    }
}