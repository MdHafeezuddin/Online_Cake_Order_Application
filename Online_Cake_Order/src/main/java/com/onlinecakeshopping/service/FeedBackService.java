package com.onlinecakeshopping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinecakeshopping.model.Feedback;

@Service
public interface FeedBackService {
	
			public List<Feedback> getAllFeedbacks();
			
}
