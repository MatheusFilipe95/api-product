package com.example.apiproduct.controller;

import com.example.apiproduct.controller.Response.Response;
import com.example.apiproduct.domain.Product;
import com.example.apiproduct.requests.ProductPostRequestBody;
import com.example.apiproduct.requests.ProductPutRequestBody;
import com.example.apiproduct.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import io.swagger.v3.oas.annotations.Operation;
import javax.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/product")
@Slf4j
@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;

    @GetMapping("/list")
    @Operation(summary = "List all products" , description = "To use pagination and sort add the params ?page='number'&sort='field' to the url" , tags = {"product"})
    public ResponseEntity<Response> listAllProduct(Pageable pageable) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("ProductService", productService.listAll(pageable)))
                        .message("Product retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveProduct(@RequestBody @Valid ProductPostRequestBody productPostRequestBody) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("ProductService", productService.saveProduct(productPostRequestBody)))
                        .message("Product created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build());

    }

    @DeleteMapping("/delete")
    public ResponseEntity<Response> deleteProduct(@RequestBody @Valid Product product) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", productService.deleteProduct(product.getId())))
                        .message("Product deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());

    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateProduct(@RequestBody @Valid ProductPutRequestBody productPutRequestBody){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("updated", productService.updateProduct(productPutRequestBody)))
                        .message("Product updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());

    }
}
