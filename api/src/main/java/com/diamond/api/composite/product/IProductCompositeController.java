package com.diamond.api.composite.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IProductCompositeController {
    @GetMapping(value = "/product-composite/{productId}", produces = "application/json")
    ProductComposite getProduct(@PathVariable int productId);
}
