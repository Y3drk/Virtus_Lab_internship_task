package com.virtuslab.internship.receipt;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceiptGenerator {

    public Receipt generate(Basket basket) { //why is it unused? doesn't make sense
        List<Product> products = basket.getProducts();
        List<ReceiptEntry> receiptEntries = new ArrayList<>();

        Map<String, Integer> entriesHolder = new HashMap<>();

        for (Product item: products) {
            if (entriesHolder.containsKey(item.name())){
                Integer currentQuantity = entriesHolder.get(item.name()) + 1;
                entriesHolder.put(item.name(), currentQuantity);
            } else {
                entriesHolder.put(item.name(), 1);
            }
        }

        for (Product item: products){
            if (entriesHolder.containsKey(item.name())){
                Integer quantity = entriesHolder.get(item.name());
                receiptEntries.add(new ReceiptEntry(item,quantity));

                entriesHolder.remove(item.name());
            }
        }

        return new Receipt(receiptEntries);
    }
}
