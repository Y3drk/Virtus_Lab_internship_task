package com.virtuslab.internship.handler;

import com.virtuslab.internship.discount.DiscountHandler;
import com.virtuslab.internship.product.ProductDb;
import com.virtuslab.internship.receipt.Receipt;
import com.virtuslab.internship.receipt.ReceiptEntry;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountHandlerTest {

    @Test
    void shouldApplyBothDiscountsWhen3OrMoreGrainsAndPriceRemainsAbove50(){
        // Given
        var productDb = new ProductDb();
        var bread = productDb.getProduct("Bread");
        var cereals = productDb.getProduct("Cereals");
        var steak = productDb.getProduct("Steak");
        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        receiptEntries.add(new ReceiptEntry(bread, 2));
        receiptEntries.add(new ReceiptEntry(cereals, 1));
        receiptEntries.add(new ReceiptEntry(steak, 1));

        var receipt = new Receipt(receiptEntries);
        var discountHandler = new DiscountHandler();
        var expectedTotalPrice = bread.price().multiply(BigDecimal.valueOf(2)).add(steak.price()).add(cereals.price()).multiply(BigDecimal.valueOf(0.85)).multiply(BigDecimal.valueOf(0.9));

        // When
        var receiptAfterDiscount = discountHandler.applyDiscounts(receipt);

        // Then
        assertEquals(expectedTotalPrice, receiptAfterDiscount.totalPrice());
        assertEquals(2, receiptAfterDiscount.discounts().size());
    }

    @Test
    void shouldApplyGrainButShouldNotApplyTenPercentWhen3OrMoreGrainsAndPriceGetsBelow50(){
        // Given
        var productDb = new ProductDb();
        var bread = productDb.getProduct("Bread");
        var cereals = productDb.getProduct("Cereals");
        var pork = productDb.getProduct("Pork");
        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        receiptEntries.add(new ReceiptEntry(bread, 3));
        receiptEntries.add(new ReceiptEntry(cereals, 1));
        receiptEntries.add(new ReceiptEntry(pork, 2));

        var receipt = new Receipt(receiptEntries);
        var discountHandler = new DiscountHandler();
        var expectedTotalPrice = bread.price().multiply(BigDecimal.valueOf(3)).add(pork.price().multiply(BigDecimal.valueOf(2))).add(cereals.price()).multiply(BigDecimal.valueOf(0.85));

        // When
        var receiptAfterDiscount = discountHandler.applyDiscounts(receipt);

        // Then
        assertEquals(expectedTotalPrice, receiptAfterDiscount.totalPrice());
        assertEquals(1, receiptAfterDiscount.discounts().size());
    }

    @Test
    void shouldNotApplyGrainButShouldApplyTenPercentWhenLessThan3GrainsAndPriceIsAbove50(){
        // Given
        var productDb = new ProductDb();
        var bread = productDb.getProduct("Bread");
        var cereals = productDb.getProduct("Cereals");
        var steak = productDb.getProduct("Steak");
        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        receiptEntries.add(new ReceiptEntry(bread, 1));
        receiptEntries.add(new ReceiptEntry(cereals, 1));
        receiptEntries.add(new ReceiptEntry(steak, 1));

        var receipt = new Receipt(receiptEntries);
        var discountHandler = new DiscountHandler();
        var expectedTotalPrice = bread.price().add(steak.price()).add(cereals.price()).multiply(BigDecimal.valueOf(0.9));

        // When
        var receiptAfterDiscount = discountHandler.applyDiscounts(receipt);

        // Then
        assertEquals(expectedTotalPrice, receiptAfterDiscount.totalPrice());
        assertEquals(1, receiptAfterDiscount.discounts().size());
    }

    @Test
    void shouldNotApplyBothDiscounts(){
        // Given
        var productDb = new ProductDb();
        var bread = productDb.getProduct("Bread");
        var cereals = productDb.getProduct("Cereals");
        var milk = productDb.getProduct("Milk");
        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        receiptEntries.add(new ReceiptEntry(bread, 1));
        receiptEntries.add(new ReceiptEntry(cereals, 1));
        receiptEntries.add(new ReceiptEntry(milk, 1));

        var receipt = new Receipt(receiptEntries);
        var discountHandler = new DiscountHandler();
        var expectedTotalPrice = bread.price().add(milk.price()).add(cereals.price());

        // When
        var receiptAfterDiscount = discountHandler.applyDiscounts(receipt);

        // Then
        assertEquals(expectedTotalPrice, receiptAfterDiscount.totalPrice());
        assertEquals(0, receiptAfterDiscount.discounts().size());
    }
}
