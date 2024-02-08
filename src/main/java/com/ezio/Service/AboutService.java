package com.ezio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezio.Entity.About;
import com.ezio.Repository.AboutRepository;

@Service
public class AboutService {

	@Autowired
	AboutRepository aboutrepo;

	public void saveAbout(About about) {
		// TODO Auto-generated method stub
		aboutrepo.save(about);
	}

	public List<About> findAll(About about) {
		// TODO Auto-generated method stub
		return aboutrepo.findAll();
	}

	public Optional<About> findById(Long id) {
		// TODO Auto-generated method stub
		return aboutrepo.findById(id);
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		 aboutrepo.deleteById(id);
	}

	public List<About> aboutInformationGetting() {
		// TODO Auto-generated method stub
		return aboutrepo.findAll();
	}

	public About findAboutById(Long id) {
		// TODO Auto-generated method stub
		return aboutrepo.findById(id).get();
	}

	public void saveAboutus(About about) {
		// TODO Auto-generated method stub
		aboutrepo.save(about);
	}

	
	

	
	
}
