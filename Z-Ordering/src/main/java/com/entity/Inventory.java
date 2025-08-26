package com.entity;

import jakarta.persistence.*;

@Entity
public class Inventory {
    @Id
    private Long id;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product productObj;
    private int stock;
    // Constructors, Getters, and Setters
    public Inventory() {}
    public Inventory(Long id, Product productObj, int stock) { this.id = id; this.productObj = productObj; this.stock = stock; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Product getProductObj() { return productObj; }
    public void setProductObj(Product productObj) { this.productObj = productObj; }
    public int getStock() { return stock; }
    public void setStock(int stock) {
    	this.stock=stock;
    }
    }