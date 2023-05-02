package com.Emart.E_market.Controller;

import com.Emart.E_market.RequestDto.SellerRequestDto;
import com.Emart.E_market.ResponseDto.ProductResponseDto;
import com.Emart.E_market.ResponseDto.SellerResponseDto;
import com.Emart.E_market.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    SellerService sellerService;

    @PostMapping("/add")
    public ResponseEntity addSeller(@RequestBody SellerRequestDto sellerRequestDto){
        String response = "";
        try{
            response = sellerService.addSeller(sellerRequestDto);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(response,HttpStatus.ACCEPTED);
    }

    @GetMapping("/get_sellers")
    public List<SellerResponseDto> findAll() {
        List<SellerResponseDto> sellerResponseDtoList = new ArrayList<>();
        return sellerService.findAll();
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity getSellerById(@PathVariable("id") int id){
        SellerResponseDto sellerResponseDto ;
        try {
            sellerResponseDto = sellerService.getSellerById(id);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(sellerResponseDto,HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/productlist/{id}")
    public ResponseEntity findProductListBySeller(@PathVariable("id") int id){
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        try {
            productResponseDtos = sellerService.findProductListBySeller(id);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(productResponseDtos,HttpStatus.ACCEPTED);
    }
}