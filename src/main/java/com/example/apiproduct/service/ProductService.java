package com.example.apiproduct.service;

import com.example.apiproduct.domain.Product;
import com.example.apiproduct.requests.ProductPostRequestBody;
import com.example.apiproduct.requests.ProductPutRequestBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> listAll(Pageable pageable);
    Product saveProduct(ProductPostRequestBody productPostRequestBody);
    Product updateProduct(ProductPutRequestBody productPutRequestBody);
    Boolean deleteProduct(Long id);
}
