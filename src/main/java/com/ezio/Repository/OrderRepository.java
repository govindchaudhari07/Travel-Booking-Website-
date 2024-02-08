package com.ezio.Repository;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ezio.Entity.Booking;

@Repository
public interface OrderRepository extends JpaRepository<Booking,Long> {

	List<Booking> findByStatus(String status);

	
	@Transactional
	@Modifying
	
	@Query("update Booking set status=:status where id=:id")
	void updatestatusById(Long id, String status);
	
	
	 List<Booking> findBookingById(Long id);
		@Query(nativeQuery = true, value = "Select count(id) from booking where date=:date")
		Integer getDailyBookingCount(String date);

		@Query(nativeQuery = true, value = "Select count(id) from booking where YEARWEEK(`date`,1)=YEARWEEK(CURDATE(),1)")
		Integer getWeeklyBookingCount();

		@Query(nativeQuery = true, value = "Select count(id) from booking WHERE MONTH(date) = MONTH(CURRENT_DATE()) AND MONTH(date) = MONTH(CURRENT_DATE())")
		Integer getMonthlyBookingCount();

    
		@Query(nativeQuery = true, value = "Select count(id) from booking WHERE YEAR(date) = YEAR(CURRENT_DATE()) ")
		Integer getYearlyBookingCount();

		@Query(nativeQuery = true, value = "Select count(id) from booking where date=:date and status='Confirm' ")
		Integer getConfirmedBookingCount(String date);

}
