package com.ezio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ezio.Entity.Booking;
import com.ezio.Repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderrepo;
	
	public void Savebooking(Booking booking)
	{
		orderrepo.save(booking);
	}

	public List<Booking> getorders() {
		// TODO Auto-generated method stub
		return orderrepo.findAll();
	}

	public List<Booking> getordersByStatus(String status) {
		// TODO Auto-generated method stub
		return orderrepo.findByStatus(status);
	}



	public Optional<Booking> findById(long id) {
		// TODO Auto-generated method stub
		
		
		return orderrepo.findById(id);
	}

	/*
	 * public void save(Booking booking) { // TODO Auto-generated method stub
	 * orderrepo.save(booking); }
	 */

	public void updatestatusById(Long id, String status) {
		// TODO Auto-generated method stub
		orderrepo.updatestatusById(id ,status);
	}

	public void deleteBooking(Long id) {
		// TODO Auto-generated method stub
		orderrepo.deleteById(id);
	}
	

}
