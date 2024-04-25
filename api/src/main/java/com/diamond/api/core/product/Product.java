package com.diamond.api.core.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product {
    private int productId;
    private String name;
    private int weight;
    private String serviceAddress;
}
