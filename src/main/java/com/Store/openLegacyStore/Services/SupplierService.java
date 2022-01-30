package com.Store.openLegacyStore.Services;

import com.Store.openLegacyStore.Beans.Product;
import com.Store.openLegacyStore.Exceptions.ErrorMessage;
import com.Store.openLegacyStore.Exceptions.SystemException;
import com.Store.openLegacyStore.repositories.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierService {
  private final   ProductRepo productRepo;

    public boolean addProduct(String name,int amount,double price){
        try {
            Product newProduct = Product.builder()
                    .amount(amount)
                    .name(name)
                    .price(price)
                    .build();
            productRepo.save(newProduct);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean updateProduct(Product product){
        boolean success;
        try{
            if (productRepo.existsById(product.getId())){
                Product updated=productRepo.findById(product.getId());
                updated.setAmount(product.getAmount());
                updated.setName(product.getName());
                updated.setPrice(product.getPrice());
                productRepo.saveAndFlush(updated);
                success=true;
            }else {throw new SystemException(ErrorMessage.ID_NOT_FOUND);
            }
        }catch (SystemException systemException){
            System.out.println(systemException.getMessage());
            success=false;
        }return success;
    }

}
