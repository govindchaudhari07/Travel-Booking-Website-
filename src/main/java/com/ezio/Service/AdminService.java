package com.ezio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezio.Entity.Admin;
import com.ezio.Entity.Testimonial;
import com.ezio.Repository.AdminRepository;
import com.ezio.Repository.OrderRepository;

;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminrepo;
	
	@Autowired
	OrderRepository orderrepo;

	public Admin checkexistByNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		String status="Active";
		return adminrepo.findByNameAndPasswordAndStatus(name,password,status);
	}

	public Integer getDailyBookingCount(String date) {
		// TODO Auto-generated method stub
		return orderrepo.getDailyBookingCount(date);
	}

	public Integer getWeekBookingCount() {
		// TODO Auto-generated method stub
		return orderrepo.getWeeklyBookingCount();
	}

	public Integer geMonthlyBookingCount() {
		// TODO Auto-generated method stub
		return orderrepo.getMonthlyBookingCount();
	}

	public Integer getYearlyBookingCount() {
		// TODO Auto-generated method stub
		return orderrepo.getYearlyBookingCount();
	}

	public Integer getConfirmedBookingCount(String date) {
		// TODO Auto-generated method stub
		return orderrepo.getConfirmedBookingCount(date );
	}


	
	
}
