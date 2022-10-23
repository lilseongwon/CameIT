package com.example.cameit.domain.bread.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Bread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    private String explain;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    @Builder
    public Bread(String name, Category category, String explain, String imageUrl, Integer price) {
        this.name = name;
        this.category = category;
        this.explain = explain;
        this.imageUrl = imageUrl;
        this.price = price;
        this.stock = 0;
    }

    public void updateBread(String name, Category category, String explain, String imageUrl, Integer price) {
        this.name = name;
        this.category = category;
        this.explain = explain;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public void subBread(Integer stock) {
        this.stock = stock;
    }

    public void addBread(Integer stock) {
        this.stock = stock;
    }
}