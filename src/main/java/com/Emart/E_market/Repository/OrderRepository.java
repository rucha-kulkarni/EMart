package com.Emart.E_market.Repository;

import com.Emart.E_market.Model.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Ordered,Integer> {
}
