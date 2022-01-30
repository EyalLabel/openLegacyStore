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
public class CustomerService {
    protected final ProductRepo productRepo;
    public boolean purchaseProduct(long productId){
        boolean success;
        Product purchase=null;
        try {
            if (productRepo.existsById(productId)){
                purchase= productRepo.findById(productId);
            }else {throw new SystemException(ErrorMessage.ID_NOT_FOUND);}
            if (purchase.getAmount()>0){
                purchase.setAmount(purchase.getAmount() - 1);
                productRepo.saveAndFlush(purchase);
                System.out.println("Purchased Successfully");
                success=true;
            }else success=false;

        } catch (SystemException systemException) {
            success=false;
            System.out.println(systemException.getMessage());
        }
        return success;
    }

}
