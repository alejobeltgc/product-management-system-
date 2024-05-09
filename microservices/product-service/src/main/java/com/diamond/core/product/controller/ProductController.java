package com.diamond.core.product.controller;

import com.diamond.api.core.product.IProductController;
import com.diamond.api.core.product.Product;
import com.diamond.api.exceptions.InvalidInputException;
import com.diamond.util.http.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements IProductController {

    private final ServiceUtil serviceUtil;

    @Autowired
    public ProductController(ServiceUtil serviceUtil){
        this.serviceUtil = serviceUtil;
    }

    @Override
    public Product getProduct(int productId) {
        if (productId < 1) {
            throw new InvalidInputException("Invalid productId: " + productId);
        }

        return new Product(productId, "name-" + productId, 123, serviceUtil.getServiceAddress());
    }
}
