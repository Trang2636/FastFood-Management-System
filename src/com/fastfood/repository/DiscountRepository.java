package com.fastfood.repository;

import com.fastfood.model.Discount;

import java.util.ArrayList;
import java.util.List;

public class DiscountRepository {
    private List<Discount> discountList = new ArrayList<>();

    // them ma giam gia
    public void addDiscount(Discount discount) {
        discountList.add(discount);
    }

    // lay toan bo ma giam gia
    public List<Discount> getAllDiscounts() {
        return discountList;
    }

    // lay ma giam gia theo code
    public Discount getDiscountByCode(String code) {
        return discountList.stream()
                .filter((discount) -> discount.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    // xoa ma giam gia theo code
    public void removeDiscount(String code) {
        discountList.removeIf((discount) -> discount.getCode().equalsIgnoreCase(code));
    }

    // lay danh sach ma giam gia con hieu luc
    public List<Discount> getValidDiscounts() {
        List<Discount> validDiscounts = new ArrayList<>();
        for (Discount discount : discountList) {
            if (discount.isValid()) {
                validDiscounts.add(discount);
            }
        }
        return validDiscounts;
    }
}
