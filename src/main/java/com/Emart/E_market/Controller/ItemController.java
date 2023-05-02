package com.Emart.E_market.Controller;

import com.Emart.E_market.ResponseDto.ItemResponseDto;
import com.Emart.E_market.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/view/{productId}")
    public ResponseEntity viewItem(@PathVariable int productId){
        ItemResponseDto itemResponseDto ;
        try {
            itemResponseDto = itemService.viewItem(productId);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(itemResponseDto,HttpStatus.CREATED);
    }
}
