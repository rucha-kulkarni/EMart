package com.Emart.E_market.Service.ServiceImpl;

import com.Emart.E_market.Converter.ProductConverter;
import com.Emart.E_market.Enum.ProductCategory;
import com.Emart.E_market.Enum.ProductStatus;
import com.Emart.E_market.Exception.SellerNotFoundException;
import com.Emart.E_market.Model.Product;
import com.Emart.E_market.Model.Seller;
import com.Emart.E_market.Repository.ProductRepository;
import com.Emart.E_market.Repository.SellerRepository;
import com.Emart.E_market.RequestDto.ProductRequestDto;
import com.Emart.E_market.ResponseDto.ProductResponseDto;
import com.Emart.E_market.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SellerRepository sellerRepository;

    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException {
        Seller seller ;
        try {
            seller = sellerRepository.findById(productRequestDto.getSellerId()).get();
        }
        catch (Exception e){
            throw new SellerNotFoundException(" not found !!!");
        }
        Product product = ProductConverter.productRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);

        seller.getProducts().add(product);

        sellerRepository.save(seller);

        ProductResponseDto productResponseDto = ProductConverter.productToProductResponseDto(product);
        return productResponseDto;
    }

    @Override
    public List<ProductResponseDto> getAllProductByCategory(ProductCategory productCategory){
        List<Product> products = productRepository.findAllByProductCategory(productCategory);

        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

        for (Product product : products){
            ProductResponseDto productResponseDto = ProductConverter.productToProductResponseDto(product);
            productResponseDtos.add(productResponseDto);
        }
        return productResponseDtos;
    }

    @Override
    public List<ProductResponseDto> getAllProductByStatus(ProductStatus productStatus){
        List<Product> products = productRepository.findAllByProductStatus(productStatus);
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

        for (Product product : products){
            ProductResponseDto productResponseDto = ProductConverter.productToProductResponseDto(product);
            productResponseDtos.add(productResponseDto);
        }
        return productResponseDtos;
    }


    @Override
    public ProductResponseDto updateProductCategory(ProductRequestDto productRequestDto){
        Product product = ProductConverter.productRequestDtoToProduct(productRequestDto);
        product.setProductCategory(productRequestDto.getProductCategory());
        productRepository.save(product);
        ProductResponseDto productResponseDto = ProductConverter.productToProductResponseDto(product);
        return productResponseDto;
    }
}