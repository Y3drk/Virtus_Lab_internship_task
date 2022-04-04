package com.virtuslab.internship.app.controllers;

import com.virtuslab.internship.app.services.BasketService;
import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.discount.DiscountHandler;
import com.virtuslab.internship.receipt.ReceiptGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Controller
public class ReceiptController {

    private final BasketService basketService;

    public ReceiptController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping({"/receipt"})
    public String handleReceipt(Model model){
        Basket temp = this.basketService.basket;
        var receiptGenerator = new ReceiptGenerator();
        var receipt = receiptGenerator.generate(temp);
        BigDecimal original_price = receipt.totalPrice();

        var discountHandler = new DiscountHandler();
        var receiptAfterDiscount = discountHandler.applyDiscounts(receipt);

        model.addAttribute("products",basketService.basket.getProducts());
        model.addAttribute("original_total_price",original_price);
        model.addAttribute("final_total_price",receiptAfterDiscount.totalPrice().setScale(2, RoundingMode.CEILING));

        return "receipt/receipt";
    }
}
