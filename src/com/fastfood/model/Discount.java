package com.fastfood.model;

import java.time.LocalDate;

public class Discount {
    private String code;
    private double percentage;
    private LocalDate expiryDate;

    public Discount(String code, double percentage, LocalDate expiryDate) {
        this.code = code;
        this.percentage = percentage;
        this.expiryDate = expiryDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isValid() {
        return LocalDate.now().isBefore(expiryDate) || LocalDate.now().isEqual(expiryDate);
    }

    @Override
    public String toString() {
        return "Code: " + code + " | Percentage: " + percentage + "%" + " | Expiry Date: " + expiryDate;
    }
}
