package com.Store.openLegacyStore.Controllers;

import com.Store.openLegacyStore.Beans.Product;
import com.Store.openLegacyStore.Exceptions.ErrorMessage;
import com.Store.openLegacyStore.Exceptions.SystemException;
import com.Store.openLegacyStore.Services.SupplierService;
import com.Store.openLegacyStore.repositories.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;
    private final ProductRepo productRepo;

    @PostMapping("addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
            return ResponseEntity.ok()
                    .body(supplierService.addProduct(product.getName(), product.getAmount(), product.getPrice()));
        }

        @PostMapping("updateProduct")
    public ResponseEntity<?>updateProduct(@RequestBody Product product) throws SystemException {
        if (productRepo.existsById(product.getId())){
            return  ResponseEntity.ok().body(supplierService.updateProduct(product));
        }throw new SystemException(ErrorMessage.UPDATE_ERROR);
        }



    }

