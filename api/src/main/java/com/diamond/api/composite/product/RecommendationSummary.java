package com.diamond.api.composite.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RecommendationSummary {
    private int recommendationId;
    private String author;
    private int rate;
}
