package com.diamond.api.core.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Review {
    private int productId;
    private int reviewId;
    private String author;
    private String subject;
    private String content;
    private String serviceAddress;
}
