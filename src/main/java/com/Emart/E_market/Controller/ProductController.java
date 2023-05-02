package com.Emart.E_market.Controller;

import com.Emart.E_market.Enum.ProductCategory;
import com.Emart.E_market.Enum.ProductStatus;
import com.Emart.E_market.RequestDto.ProductRequestDto;
import com.Emart.E_market.ResponseDto.ProductResponseDto;
import com.Emart.E_market.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto)throws Exception{
        ProductResponseDto productResponseDto;
        try{
            productResponseDto = productService.addProduct(productRequestDto);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(productResponseDto,HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/productCategory/{productCategory}")
    public List<ProductResponseDto> getAllProductByCategory(@PathVariable("productCategory") ProductCategory productCategory){
        List<ProductResponseDto> productResponseDtos =  productService.getAllProductByCategory(productCategory);
        return productResponseDtos;
    }
    @GetMapping("/get/productStatus/{productStatus}")
    public List<ProductResponseDto> getAllProductByStatus(@PathVariable("productStatus") ProductStatus productStatus){
        List<ProductResponseDto> productResponseDtos = productResponseDtos = productService.getAllProductByStatus(productStatus);
        return productResponseDtos;
    }
    @PutMapping("/update_productCategory")
    public ResponseEntity updateProductCategory(@RequestBody ProductRequestDto productRequestDto){
        ProductResponseDto productResponseDto;
        try{
            productResponseDto = productService.updateProductCategory(productRequestDto);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(productResponseDto,HttpStatus.ACCEPTED);
    }
}