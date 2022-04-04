package com.virtuslab.internship.app.controllers;

import com.virtuslab.internship.app.services.BasketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService){
        this.basketService = basketService;
    }

    @GetMapping({"/products"})
    public String getProducts(Model model){

        model.addAttribute("products", basketService.getProducts());
        model.addAttribute("cart", basketService);
        return "products/products";
    }

    @RequestMapping(value="/products", method = RequestMethod.POST)
    public String handleProducts(@RequestParam("paramName") String id, Model model) {
        System.out.println(id);
        int ultInd = id.length();
        String version = id.substring(ultInd-3,ultInd);
        String name = id.substring(0,ultInd-3);

        if (version.equals("add")) basketService.addToBasket(name);
        else basketService.deleteFromBasket(name);

        model.addAttribute("products", basketService.getProducts());
        model.addAttribute("cart", basketService);
        return "products/products";
    }
}
