package com.ezio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezio.Entity.Blog;
import com.ezio.Entity.Testimonial;
import com.ezio.Repository.TestimonialRepository;

@Service
public class TestimonialService {

	@Autowired
	TestimonialRepository testirepo;

	public void saveTestimonial(Testimonial testi) {
		// TODO Auto-generated method stub
		testirepo.save(testi);
	}

	public List<Testimonial> findAll() {
		// TODO Auto-generated method stub
		return testirepo.findAll();
	}

	public Optional<Testimonial> findById(Long id) {
		// TODO Auto-generated method stub
		return testirepo.findById(id);
	}

	public Testimonial findtestimonialById(Long id) {
		// TODO Auto-generated method stub
		return testirepo.findById(id).get();
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		testirepo.deleteById(id);
	}

	public List<Testimonial> testimonialinformationgetting() {
		// TODO Auto-generated method stub
		return testirepo.findAll();
	}

	

	
	

	
	
	
}
