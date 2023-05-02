package com.Emart.E_market.Service.ServiceImpl;

import com.Emart.E_market.Converter.CustomerConverter;
import com.Emart.E_market.Model.Cart;
import com.Emart.E_market.Model.Customer;
import com.Emart.E_market.Repository.CustomerRepository;
import com.Emart.E_market.RequestDto.CustomerRequestDto;
import com.Emart.E_market.ResponseDto.CustomerResponseDto;
import com.Emart.E_market.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto){
        Customer customer = CustomerConverter.customerRequestDtoToCustomer(customerRequestDto);
        // allocate a cart to customer
        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        // set cart in customer
        customer.setCart(cart);

        customerRepository.save(customer);

        CustomerResponseDto customerResponseDto = CustomerConverter.customerToCustomerResponseDto(customer);
        return customerResponseDto;

    }

    @Override
    public CustomerResponseDto getCustomerById(int id){
        Customer customer = customerRepository.findById(id).get();
        CustomerResponseDto customerResponseDto = CustomerConverter.customerToCustomerResponseDto(customer);
        return customerResponseDto;
    }

    @Override
    public CustomerResponseDto findByEmail(String email){
        Customer customer = customerRepository.findByEmail(email);
        CustomerResponseDto customerResponseDto = CustomerConverter.customerToCustomerResponseDto(customer);
        return customerResponseDto;
    }

    public CustomerResponseDto findByMobNo(String mobNo){
        Customer customer = customerRepository.findByMobNo(mobNo);
        CustomerResponseDto customerResponseDto = CustomerConverter.customerToCustomerResponseDto(customer);
        return customerResponseDto;
    }
}