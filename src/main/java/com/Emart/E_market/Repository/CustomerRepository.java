package com.Emart.E_market.Repository;

import com.Emart.E_market.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByEmail(String email);

    Customer findByMobNo(String mobNo);
}
