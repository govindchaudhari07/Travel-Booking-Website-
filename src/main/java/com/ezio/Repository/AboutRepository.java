package com.ezio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezio.Entity.About;

@Repository
public interface AboutRepository extends JpaRepository<About,Long> {

}
