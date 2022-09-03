package com.onlinecakeshopping.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.onlinecakeshopping.exception.OrderIdNotFoundException;
import com.onlinecakeshopping.exception.UserIdNotFoundException;
import com.onlinecakeshopping.model.Cake;
import com.onlinecakeshopping.model.Feedback;
import com.onlinecakeshopping.model.Order;
import com.onlinecakeshopping.model.RaiseComplaint;
import com.onlinecakeshopping.model.User;

@Service
public interface AdminService {
	
	/* 
	 * methods for managing the Admin
	 */
	
	public List<Cake> getAllCakes();
	public Cake addCakes(Cake cake);
	public Cake updateCakes(Cake cake);
	public Cake deleteCakes(int cakeId) ;
	public List<RaiseComplaint> viewComplaints();
	public List<Feedback> viewFeedbacks();
	public List<Order> viewOrders();
	public Cake getById(int cakeId);
	public Order getOrderById(int orderId) throws OrderIdNotFoundException;
	public User viewUserById(int userId) throws UserIdNotFoundException;
	
	
	


}
