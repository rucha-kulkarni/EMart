package com.Emart.E_market.Service.ServiceImpl;

import com.Emart.E_market.Converter.ItemConverter;
import com.Emart.E_market.Exception.ProductNotFoundException;
import com.Emart.E_market.Model.Item;
import com.Emart.E_market.Model.Product;
import com.Emart.E_market.Repository.ProductRepository;
import com.Emart.E_market.ResponseDto.ItemResponseDto;
import com.Emart.E_market.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ProductRepository productRepository;
    public ItemResponseDto viewItem(int productId) throws ProductNotFoundException {
        Product product;
        try {
            product = productRepository.findById(productId).get();
        }
        catch (Exception e){
            throw new ProductNotFoundException("Sorry !  Invalid product Id");
        }
        Item item = ItemConverter.productToItem(product);
        // Map item to product
        product.setItem(item);

        productRepository.save(product);
        ItemResponseDto itemResponseDto = ItemConverter.productToItemResponseDto(product);

        return itemResponseDto;
    }
}