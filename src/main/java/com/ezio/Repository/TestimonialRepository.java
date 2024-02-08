package com.ezio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezio.Entity.Testimonial;

@Repository
public interface TestimonialRepository extends JpaRepository<Testimonial,Long>{

	

}
