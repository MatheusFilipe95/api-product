package com.example.apiproduct.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductPutRequestBody {
    @Schema(description = "The product's Id", example = "1")
    private Long id;
    @Schema(description = "The product's name", example = "Headset Cloud II")
    private String name;
    @Schema(description = "The product's description", example = "Best gamer headset available on market")
    private String description;
    @Schema(description = "The product's name", example = "499.99")
    private Float price;
    @Schema(description = "The product's brand", example = "HyperX")
    private String brand;
}
