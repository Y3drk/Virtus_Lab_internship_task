package com.virtuslab.internship.discount;

import com.virtuslab.internship.receipt.Receipt;

public interface IDiscount {
    /**
     * Apply a discount to a receipt
     *
     * @param receipt-> receipt that we want to apply discount to.
     *
     *
     * @return new receipt with updated total price
     */
    Receipt apply(Receipt receipt);

    /**
     * Check if a receipt is eligible for the discount
     *
     * @param receipt-> receipt that we want to apply discount to.
     *
     *
     * @return boolean value indicating whether the conditions were met
     */
    private boolean shouldApply(Receipt receipt){
        return true;
    }


}
