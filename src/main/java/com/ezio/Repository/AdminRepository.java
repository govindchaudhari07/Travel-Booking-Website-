package com.ezio.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ezio.Entity.Admin;
import com.ezio.Entity.Booking;
import com.ezio.Entity.Testimonial;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	Admin findByNameAndPasswordAndStatus(String name, String password, String status);

	void save(Testimonial testimonial);
    

}
