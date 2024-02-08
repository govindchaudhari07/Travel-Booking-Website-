package com.ezio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezio.Entity.Destination;

@Repository
public interface DestinationRepository extends JpaRepository<Destination,Long> {

}
