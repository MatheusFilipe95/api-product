package com.example.apiproduct.mapper;

import com.example.apiproduct.domain.Product;
import com.example.apiproduct.requests.ProductPostRequestBody;
import com.example.apiproduct.requests.ProductPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {
    public static final ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    public abstract Product toUpdateProduct(ProductPutRequestBody productPutRequestBody);
    public abstract Product toCreateProduct(ProductPostRequestBody productPostRequestBody);
}

