package com.virtuslab.internship.app.services;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.product.Product;
import com.virtuslab.internship.product.ProductDb;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketService {

    public Basket basket;

    public BasketService() {
        this.basket = new Basket();
    }

    public void addToBasket(String name){
        var productDb = new ProductDb();
        var product = productDb.getProduct(name);
        basket.addProduct(product);
    }

    public void deleteFromBasket(String name){
        var productDb = new ProductDb();
        var product = productDb.getProduct(name);
        basket.deleteProduct(product);
    }

    public List<Product> getProducts(){
        var productDb = new ProductDb();
        List<Product> products = new ArrayList<>();
        products.add(productDb.getProduct("Apple"));
        products.add(productDb.getProduct("Orange"));
        products.add(productDb.getProduct("Banana"));
        products.add(productDb.getProduct("Potato"));
        products.add(productDb.getProduct("Tomato"));
        products.add(productDb.getProduct("Onion"));
        products.add(productDb.getProduct("Milk"));
        products.add(productDb.getProduct("Cheese"));
        products.add(productDb.getProduct("Butter"));
        products.add(productDb.getProduct("Pork"));
        products.add(productDb.getProduct("Steak"));
        products.add(productDb.getProduct("Bread"));
        products.add(productDb.getProduct("Cereals"));

        return products;
    }
}
