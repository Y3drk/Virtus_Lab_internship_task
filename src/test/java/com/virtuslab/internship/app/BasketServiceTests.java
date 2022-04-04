package com.virtuslab.internship.app;



import com.virtuslab.internship.app.services.BasketService;
import com.virtuslab.internship.product.Product;
import com.virtuslab.internship.product.ProductDb;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasketServiceTests {

    @Test
    void addsCorrectNumberOfProducts(){
        //Given
        BasketService basketService = new BasketService();

        //When
        basketService.addToBasket("Apple");
        basketService.addToBasket("Orange");

        //Then
        assertEquals(2, basketService.basket.getProducts().size());
    }

    @Test
    void selectsAllAvailableProducts(){
        //Given
        BasketService basketService = new BasketService();

        //When
        List <Product> testProducts = basketService.getProducts();

        //Then
        assertEquals(13, testProducts.size());
    }

    @Test
    void deletesCorrectNumberOfProducts(){
        //Given
        BasketService basketService = new BasketService();
        ProductDb temDB = new ProductDb();

        //When
        basketService.addToBasket("Apple");
        basketService.addToBasket("Orange");
        basketService.deleteFromBasket("Apple");
        basketService.addToBasket("Banana");
        basketService.addToBasket("Orange");
        basketService.addToBasket("Apple");
        basketService.deleteFromBasket("Orange");
        basketService.deleteFromBasket("Banana");

        //Then
        assertEquals(2, basketService.basket.getProducts().size());
        assertTrue(basketService.basket.hasProduct(temDB.getProduct("Orange")));
        assertTrue(basketService.basket.hasProduct(temDB.getProduct("Apple")));
        assertTrue(!basketService.basket.hasProduct(temDB.getProduct("Banana")));
    }


}
