package com.diamond.composite.product.helpers;

import com.diamond.api.core.product.IProductController;
import com.diamond.api.core.product.Product;
import com.diamond.api.core.recommendation.IRecommendationController;
import com.diamond.api.core.recommendation.Recommendation;
import com.diamond.api.core.review.IReviewController;
import com.diamond.api.core.review.Review;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductCompositeIntegration implements IProductController, IRecommendationController, IReviewController {

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    private final String productServiceUrl;
    private final String recommendationServiceUrl;
    private final String reviewServiceUrl;

    @Autowired
    public ProductCompositeIntegration(
            RestTemplate restTemplate,
            ObjectMapper mapper,
            @Value("${app.product-service.host}")           String productServiceHost,
            @Value("${app.product-service.port}")           int productServicePort,
            @Value("${app.recommendation-service.host}")    String recommendationServiceHost,
            @Value("${app.recommendation-service.port}")    int recommendationServicePort,
            @Value("${app.review-service.host}")            String reviewServiceHost,
            @Value("${app.review-service.port}")            int reviewServicePort) {

        this.restTemplate = restTemplate;
        this.mapper = mapper;

        productServiceUrl = "http://" + productServiceHost + ":" + productServicePort + "/product/";
        recommendationServiceUrl = "http://" + recommendationServiceHost + ":" + recommendationServicePort + "/recommendation?productId=";
        reviewServiceUrl = "http://" + reviewServiceHost + ":" + reviewServicePort + "/review?productId=";
    }

    @Override
    public Product getProduct(int productId) {
        String url = productServiceUrl + productId;
        return restTemplate.getForObject(url, Product.class);
    }

    @Override
    public List<Recommendation> getRecommendations(int productId) {
        String url = recommendationServiceUrl + productId;
        return restTemplate
                .exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Recommendation>>() {})
                .getBody();
    }

    @Override
    public List<Review> getReviews(int productId) {
        String url = reviewServiceUrl + productId;
        return restTemplate
                .exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Review>>() {})
                .getBody();
    }
}
