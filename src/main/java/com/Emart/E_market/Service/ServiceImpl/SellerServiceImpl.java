package com.Emart.E_market.Service.ServiceImpl;

import com.Emart.E_market.Converter.ProductConverter;
import com.Emart.E_market.Converter.SellerConverter;
import com.Emart.E_market.Exception.SellerNotFoundException;
import com.Emart.E_market.Model.Product;
import com.Emart.E_market.Model.Seller;
import com.Emart.E_market.Repository.SellerRepository;
import com.Emart.E_market.RequestDto.SellerRequestDto;
import com.Emart.E_market.ResponseDto.ProductResponseDto;
import com.Emart.E_market.ResponseDto.SellerResponseDto;
import com.Emart.E_market.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    SellerRepository sellerRepository;

    @Override
    public String addSeller(SellerRequestDto sellerRequestDto) throws Exception {
        Seller seller ;
        try {
            seller = SellerConverter.SellerRequestDtoToSeller(sellerRequestDto);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
        sellerRepository.save(seller);
        return "Congrats !! Now you can sell";
    }

    @Override
    public SellerResponseDto getSellerById(int id) throws SellerNotFoundException {
        Seller seller ;
        try {
            seller = sellerRepository.findById(id).get();
        }
        catch (Exception e){
            throw new SellerNotFoundException("Invalid seller id");
        }
        SellerResponseDto sellerResponseDto = SellerConverter.sellerToSellerResponseDto(seller);
        return  sellerResponseDto;
    }

    @Override
    public List<ProductResponseDto> findProductListBySeller(int id) throws SellerNotFoundException {
        Seller seller ;
        try {
            seller = sellerRepository.findById(id).get();
        }
        catch (Exception e){
            throw new SellerNotFoundException("Invalid seller id");
        }
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        List<Product> products = seller.getProducts();
        for(Product product : products){
            ProductResponseDto productResponseDto = ProductConverter.productToProductResponseDto(product);
            productResponseDtos.add(productResponseDto);
        }
        return productResponseDtos;
    }

    @Override
    public List<SellerResponseDto> findAll(){
        List<Seller> sellers = sellerRepository.findAll();
        List<SellerResponseDto> sellerReponseDtos =new ArrayList<>();
        for(Seller seller: sellers){
            SellerResponseDto sellerReponseDto = SellerConverter.sellerToSellerResponseDto(seller);
            sellerReponseDtos.add(sellerReponseDto);
        }
        return sellerReponseDtos;
    }
}