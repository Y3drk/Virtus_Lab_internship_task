package com.virtuslab.internship.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static javax.swing.UIManager.get;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppApplication.class})
@WebAppConfiguration
@SpringBootTest
class AppApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void givenWacWhenServletContextThenItProvidesReceiptController() {
		ServletContext servletContext = webApplicationContext.getServletContext();

		assertNotNull(servletContext);
		assertTrue(servletContext instanceof MockServletContext);
		assertNotNull(webApplicationContext.getBean("receiptController"));
	}

	@Test
	public void givenStartPageURIWhenMockMVCThenReturnsIndexViewName() {
		try {
			this.mockMvc.perform((RequestBuilder) get("/")).andDo(print())
					.andExpect(view().name("start"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenProductsPageURIWhenMockMVCThenReturnsProductsViewName() {
		try {
			this.mockMvc.perform((RequestBuilder) get("/products")).andDo(print())
					.andExpect(view().name("products"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenReceiptPageURIWhenMockMVCThenReturnsIndexViewName() {
		try {
			this.mockMvc.perform((RequestBuilder) get("/")).andDo(print())
					.andExpect(view().name("receipt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
