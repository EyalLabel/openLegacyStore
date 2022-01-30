package com.Store.openLegacyStore.Controllers;

import com.Store.openLegacyStore.Beans.Product;
import com.Store.openLegacyStore.Exceptions.ErrorMessage;
import com.Store.openLegacyStore.Exceptions.SystemException;
import com.Store.openLegacyStore.Services.CustomerService;
import com.Store.openLegacyStore.Services.SupplierService;
import com.Store.openLegacyStore.repositories.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Customer")
@RequiredArgsConstructor
public class CustomerController {
    private final ProductRepo productRepo;
    private final CustomerService customerService;
    @PostMapping("buyProduct/{productId}")
    public ResponseEntity<?> addProduct(@PathVariable long productId) throws SystemException {
        if (productRepo.existsById(productId)){
            return  ResponseEntity.ok().body(customerService.purchaseProduct(productId));
        }throw new SystemException(ErrorMessage.UPDATE_ERROR);
    }
}
