package com.Emart.E_market.Repository;

import com.Emart.E_market.Enum.ProductCategory;
import com.Emart.E_market.Enum.ProductStatus;
import com.Emart.E_market.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllByProductCategory(ProductCategory productCategory);

    List<Product> findAllByProductStatus(ProductStatus productStatus);
}
