package com.candreotti.demo.repositories;

import com.candreotti.demo.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
