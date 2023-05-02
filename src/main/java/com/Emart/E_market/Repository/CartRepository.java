package com.Emart.E_market.Repository;


import com.Emart.E_market.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
