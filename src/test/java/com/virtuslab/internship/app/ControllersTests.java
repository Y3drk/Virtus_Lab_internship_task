package com.virtuslab.internship.app;

import com.virtuslab.internship.app.controllers.BasketController;
import com.virtuslab.internship.app.controllers.ReceiptController;
import com.virtuslab.internship.receipt.Receipt;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public final class ControllersTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ReceiptController receiptController;
    private BasketController basketController;
}
