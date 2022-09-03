package com.onlinecakeorder.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.onlinecakeshopping.OnlineCakeShoppingApplication;
import com.onlinecakeshopping.dao.CakeRepository;
import com.onlinecakeshopping.dao.CartRepository;
import com.onlinecakeshopping.dao.FeedbackRepository;
import com.onlinecakeshopping.dao.OrderRepository;
import com.onlinecakeshopping.dao.RaiseComplaintRepository;
import com.onlinecakeshopping.dao.RegistrationRepository;
import com.onlinecakeshopping.dao.UserRepository;
import com.onlinecakeshopping.model.Cake;
import com.onlinecakeshopping.model.Cart;
import com.onlinecakeshopping.model.Feedback;
import com.onlinecakeshopping.model.Order;
import com.onlinecakeshopping.model.RaiseComplaint;
import com.onlinecakeshopping.model.RegistrationForm;
import com.onlinecakeshopping.service.AdminService;
import com.onlinecakeshopping.service.CustomerSupportService;
import com.onlinecakeshopping.service.UserService;

@SpringBootTest(classes=OnlineCakeShoppingApplication.class)
class OnlineCakeOrderApplicationTests {
	
	
	@Autowired
	private CustomerSupportService custServe;
	
	@Autowired
	private AdminService adServe;
	
	@Autowired
	private UserService userServe;
	
	@MockBean
	private CakeRepository cakeRepo;
	
    private MockMvc mockMvc;

	
	@MockBean
	private FeedbackRepository feedbackRepo;
	
	@MockBean
	private RaiseComplaintRepository complainRepo;
	
	@MockBean
	private UserRepository userRepo;
	
	@MockBean
	private CartRepository cartRepo;
	
	@MockBean
	private OrderRepository orderRepo;
	
	@MockBean
	private RegistrationRepository regRepo;


	@Test
	public void getCakeTest()
	{
		when(cakeRepo.findAll())
		.thenReturn(Stream.of(new Cake(9,"Pista",225,1)).collect(Collectors.toList()));
		assertEquals(1, adServe.getAllCakes().size());
	}
	
	
	@Test
	public void testViewFeedback() {
		when(feedbackRepo.findAll())
		.thenReturn(Stream.of(new Feedback(1,"On time delivery")).collect(Collectors.toList()));
		assertEquals(1, adServe.viewFeedbacks().size());
	}
	
	
	@Test
	public void testDeleteCakes() {
		int id = 9;
		adServe.deleteCakes(9);
		verify(cakeRepo, times(1)).deleteById(9);
	}
	
	@Test
	public void testAddCake(){
      Cake cake = new Cake(9,"Pista",225,1);		
		Mockito.when(cakeRepo.save(cake)).thenReturn(cake);
		String urlTemplate;
		MockHttpServletRequestBuilder mockRequest = (MockHttpServletRequestBuilder) ((Object) MockMvcRequestBuilders.post(urlTemplate="/addcake")
				.content(asJsonString(cake))
              .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));	
	}
	public static String asJsonString(final Object obj) {
      try {
          return new ObjectMapper().writeValueAsString(obj);
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
  }

	
	@Test
	public void testViewCompliant() {
		when(complainRepo.findAll())
		.thenReturn(Stream.of(new RaiseComplaint(1,"Not in time")).collect(Collectors.toList()));
		assertEquals(1, adServe.viewComplaints().size());
	}
	
	
	@Test
	public void testViewOrder() {
		
		Cart cart = new Cart();
		
		when(orderRepo.findAll()).thenReturn(Stream.of(new Order(1, "Done", "Done", cart)).collect(Collectors.toList()));
		assertEquals(1, adServe.viewOrders().size());
	}
	
	
	/*
     * Test Cases for User
     */

    @Test
    public void testViewAllCakes() {
        when(cakeRepo.findAll()).thenReturn(Stream.of(new Cake(1, "Black-Forest", 550, 1)).collect(Collectors.toList()));
        assertEquals(1, userServe.viewAllCakes().size());
    }

    @Test
    public void testViewCart() {
        Cake cake = new Cake(112, "Cucumber", 10, 2);
        when(cartRepo.findAll()).thenReturn(Stream.of(new Cart(11, 10, "R234", cake)).collect(Collectors.toList()));
        assertEquals(1, userServe.viewCart().size());
    }
    
    @Test
	public void testDeleteCakesById() {
		int cake_id = 2;
		userServe.deleteCakebyId(2);
		verify(cartRepo, times(1)).deleteById(2);
	}
    
    @Test
	public void testGiveFeedback(){
    	Feedback feedback = new Feedback(2,"Nice Packaging");		
		Mockito.when(feedbackRepo.save(feedback)).thenReturn(feedback);
		String urlTemplate;
		MockHttpServletRequestBuilder mockRequest = (MockHttpServletRequestBuilder) ((Object) MockMvcRequestBuilders.post(urlTemplate="/feedback")
				.content(asJsonString2(feedback))
              .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));	
	}
	public static String asJsonString2(final Object obj) {
      try {
          return new ObjectMapper().writeValueAsString(obj);
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
  }
    
	 @Test
		public void testRaiseComplaint(){
		 RaiseComplaint raisecomplaint = new RaiseComplaint(3,"quality is unsatisfaction");		
			Mockito.when(complainRepo.save(raisecomplaint)).thenReturn(raisecomplaint);
			String urlTemplate;
			MockHttpServletRequestBuilder mockRequest = (MockHttpServletRequestBuilder) ((Object) MockMvcRequestBuilders.post(urlTemplate="/raise")
					.content(asJsonString3(raisecomplaint))
	              .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));	
		}
		public static String asJsonString3(final Object obj) {
	      try {
	          return new ObjectMapper().writeValueAsString(obj);
	      } catch (Exception e) {
	          throw new RuntimeException(e);
	      }
	  }
		
		 @Test
		    public void testaddcakeToCart(){
		      Cart carts = new Cart(5,120, "In process", null);        
		        Mockito.when(userRepo.save(carts)).thenReturn(userRepo);
		        String urlTemplate;
		        MockHttpServletRequestBuilder mockRequest = (MockHttpServletRequestBuilder) ((Object) MockMvcRequestBuilders.post(urlTemplate="/addcart")
		                .content(asJsonString4(carts))
	              .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));	
		    }
		    public static String asJsonString4(final Object obj) {
		      try {
		          return new ObjectMapper().writeValueAsString(obj);
		      } catch (Exception e) {
		          throw new RuntimeException(e);
		      }
		  }
    /*
     * Test Cases for CustomerSupportService
     */

    @Test
    public void testViewComplaints() {
        when(complainRepo.findAll())
        .thenReturn(Stream.of(new RaiseComplaint(11, "Bad")).collect(Collectors.toList()));
        assertEquals(1, custServe.viewComplaints().size());
    }
	

	/*
     * Test Cases for Cart
     */

	
	@Test
	public void testMakeOrder(){
      Order order = new Order(2025,"Your order is on the way","payment failed", null);		
		Mockito.when(orderRepo.save(order)).thenReturn(order);
		String urlTemplate;
		MockHttpServletRequestBuilder mockRequest = (MockHttpServletRequestBuilder) ((Object) MockMvcRequestBuilders.post(urlTemplate="/makeorder")
				.content(asJsonString(order))
              .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));	
	}
	public static String asJsonString1(final Object obj) {
      try {
          return new ObjectMapper().writeValueAsString(obj);
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
  }
	
	/*
     * Test Cases for Registration
     */
    @Test
    public void testAddRegistration(){
      RegistrationForm reg = new RegistrationForm(1,"14th ward subhash nagar","Sandur","Sanjana","sanju@123","Karnataka");        
        Mockito.when(regRepo.save(reg)).thenReturn(reg);
        String urlTemplate;
        MockHttpServletRequestBuilder mockRequest = (MockHttpServletRequestBuilder) ((Object) MockMvcRequestBuilders.post(urlTemplate="/addreg")
                .content(asJsonString5(reg))
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));	
    }
    public static String asJsonString5(final Object obj) {
      try {
          return new ObjectMapper().writeValueAsString(obj);
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
  }
    



}
