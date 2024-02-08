package com.ezio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezio.Entity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {

}
