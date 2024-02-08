package com.ezio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezio.Entity.Destination;
import com.ezio.Repository.DestinationRepository;

@Service
public class DestinationService {
	
	@Autowired
	DestinationRepository destirepo;

	public void saveDestination(Destination destination) {
		// TODO Auto-generated method stub
		//System.out.println(" *****Services  ****"+destination.getDestinations()+ " "+destination.getImages()+"  "+destination.getPrice()); // 
		destirepo.save(destination);
		
	}

	public List<Destination> findAllDestination(Destination destination) {
		// TODO Auto-generated method stub
		return  destirepo.findAll();
	}

	public Optional<Destination> findById(Long id) {
		// TODO Auto-generated method stub
		
		return destirepo.findById(id);
	}

	public void editdesti(Destination destination) {
		// TODO Auto-generated method stub
		destirepo.save(destination);
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		destirepo.deleteById(id);
	}

	public Destination getDataById(Long id) {
		// TODO Auto-generated method stub
		return destirepo.findById(id).get();
	}

	public List<Destination> destinationinformationgeti() {
		// TODO Auto-generated method stub
		
		return destirepo.findAll();
	}

}
