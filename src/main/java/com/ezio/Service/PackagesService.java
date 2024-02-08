package com.ezio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezio.Entity.Packagefield;
import com.ezio.Repository.PackagesRepository;

@Service
public class PackagesService {

	@Autowired
	PackagesRepository packagerepo;

	public void savePackage(Packagefield pack) {
		// TODO Auto-generated method stub
		packagerepo.save(pack);
	}

	public List<Packagefield> findAll(Packagefield packagefield) {
		// TODO Auto-generated method stub
		return packagerepo.findAll();
	}

	public Optional<Packagefield> findById(Long id) {
		// TODO Auto-generated method stub
		return packagerepo.findById(id);
	}

	public Packagefield findPackageById(Long id) {
		// TODO Auto-generated method stub
		return packagerepo.findById(id).get();
	}

	public void DeleteById(Long id) {
		// TODO Auto-generated method stub
	packagerepo.deleteById(id);
	}

	public List<Packagefield> packageinformationgetting() {
		// TODO Auto-generated method stub
		return packagerepo.findAll();
	}
}
