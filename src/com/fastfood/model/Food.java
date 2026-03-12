package com.fastfood.model;

public class Food extends MenuItem {
    public Food(int id, String name, double price, int stock) {
        super(id, name, price, stock);
    }

    @Override
    public double calculatePrice() {
        return getPrice()* 1.05; //them 5% thue
    }
    @Override
    public String toString() {
        return super.toString() +
                " | Loai: Food" +
                " | Gia tinh: " + String.format("%.2f", calculatePrice());
    }
}
