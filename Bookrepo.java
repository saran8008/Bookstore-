package com.mytools.store2.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytools.store2.entity.Book;

@Repository

public interface Bookrepo extends JpaRepository<Book, Integer>{
	


}
