package com.fastfood.model;

public abstract class MenuItem {
    private int id;
    private String name;
    private double price;
    private int stock;

    public MenuItem(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock=stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // phuong thuc tinh gia(da hinh)
    public abstract double calculatePrice();

    @Override
    public String toString() {
        return "ID: " + id +
                " | Ten: " + name +
                " | Price: " + price +
                " | Stock: " + stock;
    }
}
