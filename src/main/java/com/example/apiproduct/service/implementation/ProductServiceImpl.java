package com.example.apiproduct.service.implementation;

import com.example.apiproduct.domain.Product;
import com.example.apiproduct.mapper.ProductMapper;
import com.example.apiproduct.repository.ProductRepository;
import com.example.apiproduct.requests.ProductPostRequestBody;
import com.example.apiproduct.requests.ProductPutRequestBody;
import com.example.apiproduct.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Page<Product> listAll(Pageable pageable) {
        log.info("Listing all products");
        return productRepository.findAll(pageable);
    }

    @Override
    public Product saveProduct(ProductPostRequestBody productPostRequestBody) {
        log.info("Saving new product: {}", productPostRequestBody.getClass().getName());
        return productRepository.save(ProductMapper.INSTANCE.toCreateProduct(productPostRequestBody));
    }

    @Override
    public Product updateProduct(ProductPutRequestBody productPutRequestBody){
        log.info("Updating product: {}", productPutRequestBody.getClass().getName());
        return productRepository.save(ProductMapper.INSTANCE.toUpdateProduct(productPutRequestBody));
    }

    @Override
    public Boolean deleteProduct(Long id) {
        return null;
    }
}
