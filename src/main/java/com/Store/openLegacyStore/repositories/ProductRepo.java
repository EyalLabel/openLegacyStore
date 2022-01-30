package com.Store.openLegacyStore.repositories;

import com.Store.openLegacyStore.Beans.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ProductRepo extends JpaRepository<Product, Integer> {
    Product findById(long id);
    void deleteById(long id);
    boolean existsById(long id);
}
