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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.onlinecakeshopping.exception.OrderIdNotFoundException;
import com.onlinecakeshopping.exception.UserIdNotFoundException;
import com.onlinecakeshopping.model.Cake;
import com.onlinecakeshopping.model.Feedback;
import com.onlinecakeshopping.model.Order;
import com.onlinecakeshopping.model.RaiseComplaint;
import com.onlinecakeshopping.model.User;
import com.onlinecakeshopping.service.AdminService;

//it is used to handle requests made by the client
@RestController
//it is an header based mechanism that allows a server to indicates any origin
@CrossOrigin("*")
//it is used to map http requests with handler methods
@RequestMapping("/admin")
public class AdminController {
	
	//this is admin controller
	@Autowired
	private AdminService adServe;
	
	/*
	 * Controller for the requests related to the Cake store
	 */
	
	// requests the controller to add cake in cake store
	
	
	//localhost:8091/onlinecakeorder/admin/addcake**done
	@PostMapping("/addcake")
	public ResponseEntity<Cake> addcake(@RequestBody Cake cake) {
		adServe.addCakes(cake);
		return new ResponseEntity("Cake added", HttpStatus.OK);

	}
	
	// requests the controller to delete by cake id in cake store
	
	
	//localhost:8091/onlinecakeorder/admin/deleteById/**done
	@DeleteMapping("/deleteById/{cakeId}")
	public ResponseEntity<Cake> deleteVegById(@PathVariable("cakeId") int cakeId)  {
		adServe.deleteCakes(cakeId);
		return new ResponseEntity("Cake Deleted", HttpStatus.OK);

	}
	
	
	// requests the controller to update cake in cake store
	
	
	//localhost:8091/onlinecakeorder/admin/update**--done
	@PutMapping("/update")
	public ResponseEntity<Cake> updateCakes(@RequestBody Cake cakes) {
		Cake updatecake = adServe.updateCakes(cakes);

		return new ResponseEntity("Cake updated successfully", HttpStatus.OK);

	}
	
	//requests the controller to get all cake from cake store
	
	//localhost:8091/onlinecakeorder/admin/allcake**--done
	@GetMapping("/allcake")
	public ResponseEntity<List<Cake>> getAllCake() {
		List<Cake> cakeList = adServe.getAllCakes();
		if (cakeList.isEmpty()) {
			return new ResponseEntity("Sorry no cake list found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Cake>>(cakeList, HttpStatus.OK);
	}
		
	/*
	 * Controller for the requests related to the Raise Complaint
	 */

	// requests the controller to view all complaint raised by user
	
	
	//localhost:8091/onlinecakeorder/admin/viewallraise--done
		@GetMapping("/viewallraise")
		public ResponseEntity<List<RaiseComplaint>> viewCompliant() {
			List<RaiseComplaint> raisecomplaint = adServe.viewComplaints();
			return new ResponseEntity<List<RaiseComplaint>>(raisecomplaint, HttpStatus.OK);

		}
		
		
		/*
		 * Controller for the requests related to the feedback
		 */
		// requests the controller to view all feedback given by user
		
		//localhost:8091/onlinecakeorder/admin/viewfeedback**--done
		
		@GetMapping("/viewfeedback")
		public ResponseEntity<List<Feedback>> viewFeedback() {
			List<Feedback> viewfeedback = adServe.viewFeedbacks();
			return new ResponseEntity(viewfeedback, HttpStatus.OK);

		}
		
		
		
		/*
		 * Controller for the requests related to the Order
		 */
		// requests the controller to view all order by user
		
		
		//localhost:8091/onlinecakeorder/admin/vieworder--done
		@GetMapping("/vieworder")
		public ResponseEntity<List<Order>> viewOrders() {
			List<Order> viewOrder = adServe.viewOrders();
			return new ResponseEntity(viewOrder, HttpStatus.OK);

		}
		
		
		
		/*
		 * Controller for the requests related to the Cake
		 */
		// requests the controller to view cake by cakeid
		
		
		
		//localhost:8091/onlinecakeorder/admin/cakebyid/--done
		@GetMapping("/cakebyid/{cakeId}")
		public ResponseEntity getVegById(@PathVariable("cakeId") int cakeId) {
			Cake cake = adServe.getById(cakeId);
			return new ResponseEntity<Object>(cake, HttpStatus.OK);

		}
		
		
		/*
		 * Controller for the requests related to the Order
		 */
		// requests the controller to view order by orderid
		
		//localhost:8091/onlinecakeorder/admin/orderbyid/--done
		
		@GetMapping("/orderbyid/{orderId}")
		public ResponseEntity geOrderById(@PathVariable("orderId") int orderId) throws OrderIdNotFoundException {
			Order order = adServe.getOrderById(orderId);
			return new ResponseEntity<Object>(order, HttpStatus.OK);

		}
		
		/*
		 * Controller for the requests related to the User
		 */
		// requests the controller to view user by userid
		
		//localhost:8091/onlinecakeorder/admin/userbyid/--done
		@GetMapping("/userbyid/{userId}")
		public ResponseEntity geUserById(@PathVariable("userId") int userId) throws UserIdNotFoundException{
			User user = adServe.viewUserById(userId);
			return new ResponseEntity<Object>(user, HttpStatus.OK);

		}
		

}
