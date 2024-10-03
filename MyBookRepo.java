package com.mytools.store2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytools.store2.entity.MyBookList;

@Repository

public interface MyBookRepo extends JpaRepository<MyBookList,Integer>{

}
