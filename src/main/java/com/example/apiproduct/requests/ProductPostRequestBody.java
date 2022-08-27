package com.example.apiproduct.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ProductPostRequestBody {
    @NotEmpty(message = "The product name cannot be empty")
    @Schema(description = "The product's name", example = "Headset Cloud II")
    private String name;

    @NotEmpty(message = "The product description cannot be empty")
    @Schema(description = "The product's description", example = "Best gamer headset available on market")
    private String description;

    @NotEmpty(message = "The product price cannot be empty")
    @Schema(description = "The product's name", example = "499.99")
    private Float price;

    @NotEmpty(message = "The product brand cannot be empty")
    @Schema(description = "The product's brand", example = "HyperX")
    private String brand;
}

