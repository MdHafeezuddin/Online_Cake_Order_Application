package com.onlinecakeshopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinecakeshopping.dao.CakeRepository;
import com.onlinecakeshopping.dao.FeedbackRepository;
import com.onlinecakeshopping.dao.OrderRepository;
import com.onlinecakeshopping.dao.RaiseComplaintRepository;
import com.onlinecakeshopping.dao.UserRepository;

import com.onlinecakeshopping.exception.OrderIdNotFoundException;
import com.onlinecakeshopping.exception.UserIdNotFoundException;
import com.onlinecakeshopping.model.Cake;
import com.onlinecakeshopping.model.Feedback;
import com.onlinecakeshopping.model.Order;
import com.onlinecakeshopping.model.RaiseComplaint;
import com.onlinecakeshopping.model.User;


@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private CakeRepository cakeRepo;
	
	// connecting the service implementation with the cake repository
	


	@Autowired
	private RaiseComplaintRepository raiseRepo;
	
	// connecting the service implementation with the cake repository
	
	

	@Autowired
	private FeedbackRepository feedbackRepo;
	
	// connecting the service implementation with the cake repository
	
	

	@Autowired
	private OrderRepository orderRepo;
	
	// connecting the service implementation with the order repository
	
	@Autowired
	private UserRepository userRepo;
	
	// connecting the service implementation with the User repository


	// method implementing to add Cake in Cake Store
	@Override//
	public Cake addCakes(Cake cake) {
		Cake food= cakeRepo.saveAndFlush(cake);
		return food;
	}
	
	// method implementing to delete Cake in Cake Store

	@Override
	public Cake deleteCakes(int cakeId) {
		
		 cakeRepo.deleteById(cakeId);
		return null;
		
	}
	
	// method implementing to update Cakes in Cake Store

	@Override
	public Cake updateCakes(Cake Cake) {
		Cake UpdatedCake = cakeRepo.saveAndFlush(Cake);
		return UpdatedCake;
	}

	// method implementing to view all Cakes in Cake Store

	@Override
	public List<Cake> getAllCakes() {
		
		return cakeRepo.findAll();
	}
	
	// method implementing to view all complaints raised in Cake Store by customer

	@Override
	public List<RaiseComplaint> viewComplaints() {
		
		return raiseRepo.findAll();
	}
	
	// method implementing to view feedbacks given by customer

	@Override
	public List<Feedback> viewFeedbacks() {
		
		return feedbackRepo.findAll();
	}
	
	// method implementing to view orders in Cake Store

	@Override
	public List<Order> viewOrders() {
		
		return orderRepo.findAll();
	}
	// method implementing to get Cake byId in Cake Store

	@Override
	public Cake getById(int CakeId){
		
		Optional<Cake> Cake=cakeRepo.findById(CakeId);
		return Cake.get();
		
	}
	// method implementing to  getorder by id in Cake Store

	@Override
	public Order getOrderById(int orderId) {
		try {
		Optional<Order> orderById=orderRepo.findById(orderId);
		return orderById.get();
		}
		catch (Exception e) {
			throw new OrderIdNotFoundException("Order id is not found");
		}
		
	}
	
	// method implementing to view user by the userId in Cake Store

	@Override
	public User viewUserById(int userId) throws UserIdNotFoundException{
		try {
		Optional<User> user=userRepo.findById(userId);
		return user.get();
		}catch (Exception e) {
			throw new UserIdNotFoundException("Entered user id is not found");
		}
	}

	


	
}