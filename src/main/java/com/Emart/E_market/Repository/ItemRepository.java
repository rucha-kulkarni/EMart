package com.Emart.E_market.Repository;

import com.Emart.E_market.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
