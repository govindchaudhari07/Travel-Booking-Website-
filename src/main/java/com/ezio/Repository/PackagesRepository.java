package com.ezio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezio.Entity.Packagefield;

@Repository
public interface PackagesRepository extends JpaRepository<Packagefield,Long>{

}
