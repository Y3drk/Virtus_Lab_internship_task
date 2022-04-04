package com.virtuslab.internship.discount;

import com.virtuslab.internship.receipt.Receipt;

import java.util.ArrayList;
import java.util.List;

public class DiscountHandler {
    List<IDiscount> discounts = new ArrayList<>();

    public DiscountHandler(){
        this.discounts.add(new GrainDiscount());
        this.discounts.add(new TenPercentDiscount());
    }

    public Receipt applyDiscounts(Receipt receipt){
        for (IDiscount discount: this.discounts){
            receipt = discount.apply(receipt);
        }
        return receipt;
    }
}
