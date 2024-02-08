package com.ezio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezio.Entity.Blog;
import com.ezio.Repository.BlogRepository;

@Service
public class BlogService {

	@Autowired
	BlogRepository blogrepo;

	public void saveblog(Blog blog) {
		// TODO Auto-generated method stub
		blogrepo.save(blog);
	}
	
	public List<Blog> findAll(){
		
		return blogrepo.findAll();
	}

	public Optional<Blog> findById(Long id) {
		// TODO Auto-generated method stub
		return blogrepo.findById(id);
	}

	public Blog findblogById(Long id) {
		// TODO Auto-generated method stub
		return blogrepo.findById(id).get();
	}

	public void saveBlog(Blog blog) {
		// TODO Auto-generated method stub
		blogrepo.save(blog);	
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		blogrepo.deleteById(id);
	}

	public List<Blog> blogInformationGetting() {
		// TODO Auto-generated method stub
		return blogrepo.findAll();
	}
}
