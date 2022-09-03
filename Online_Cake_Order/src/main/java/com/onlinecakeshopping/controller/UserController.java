package com.onlinecakeshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.onlinecakeshopping.model.Cake;
import com.onlinecakeshopping.model.Cart;
import com.onlinecakeshopping.model.Feedback;
import com.onlinecakeshopping.model.RaiseComplaint;
import com.onlinecakeshopping.service.UserService;

@RestController
@CrossOrigin(origins ="*", allowedHeaders= "*")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userServe;
	
	/*
	 *  Controller for the requests related to the Feedback
	 */	
	
	//requests the controller to give Feedback

	
	
	 //http://localhost:8091/onlinecakeorder/user/feedback--done
	
	@PostMapping("/feedback") 
	public ResponseEntity<Feedback> giveFeedback(@RequestBody Feedback feedback)
	{
	userServe.giveFeedback(feedback);
		return new ResponseEntity("Feedback Recorded",HttpStatus.OK);
		
	}
	
	/*
	 *  Controller for the requests related to the cake store
	 */	
	//requests the controller to view all cakes

	//http://localhost:8091/onlinecakeorder/user/allcake--done

	@GetMapping("/allcake") 
	public ResponseEntity<List<Cake>> viewAllcakes()
	{
		List<Cake> viewAllCakes = userServe.viewAllCakes();
		
		return  new ResponseEntity<List<Cake>>(viewAllCakes, HttpStatus.OK);
		
	}
	
	/*
	 *  Controller for the requests related to the cart
	 */
	
	//requests the controller to add cake to Cart
	


	//http://localhost:8091/onlinecakeorder/user/addcaketocart--done
	
	@PostMapping("/addcaketocart") 
	public ResponseEntity<Cart> addToCart(@RequestBody Cart cart)
	{
		Cart carts= userServe.addcakeToCart(cart);
		return new ResponseEntity(carts, HttpStatus.OK) ;
		
	}
	
	//requests the controller to view Cart
	
	//http://localhost:8091/onlinecakeorder/user/viewcart--done
	
	@GetMapping("/viewcart")
	public ResponseEntity<List<Cart>> viewCart()
	{
		List<Cart> viewAddCart = userServe.viewCart();
		return new ResponseEntity<List<Cart>>(viewAddCart, HttpStatus.OK);
		
	}
	
	
	
	//requests the controller to delete vegetable by id in cart 
	
	//http://localhost:8091/onlinecakeorder/user/deletebycakeid--error
	
	
	@DeleteMapping("/deletebycakeid/{cakeId}")
	public ResponseEntity deleteById(@PathVariable("cakeId") int cakeId) 
	{
		userServe.deleteCakebyId(cakeId);
		return new ResponseEntity("Successfully deleted from cart ", HttpStatus.OK);
		
	}
	
	/*
	 *  Controller for the requests related to the raiseCompliant
	 */
	
	//requests the controller to raise Compliant

	//http://localhost:8091/onlinecakeorder/user/raise--done
	@PostMapping("/raise")
	public ResponseEntity<RaiseComplaint> raiseCompliant(@RequestBody RaiseComplaint raisecompliant)
	{
		userServe.raiseCompliant(raisecompliant);
		return new ResponseEntity("Compliant is Raised successfully", HttpStatus.OK);
		
	}
	
	/*
	 *  Controller for the requests related to the cake
	 */
	
	//requests the controller to get cake by cakeId
	
	
	//localhost:8091/onlinecakeorder/user/cakebyid/--done
	@GetMapping("/cakebyid/{cakeId}")
	public ResponseEntity getcakeById(@PathVariable("cakeId") int cakeId) {
		Cake cake=userServe.getById(cakeId);
		return new ResponseEntity<Object>(cake,HttpStatus.OK);
		
	}
	
	
	
	
	

}
