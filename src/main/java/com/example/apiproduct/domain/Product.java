package com.example.apiproduct.domain;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String name;

    @NotEmpty
    private String description;

    @NotNull
    @NotEmpty
    private Float price;

    @NotEmpty
    private String brand;

    @NotEmpty
    private Long storeId;
}
