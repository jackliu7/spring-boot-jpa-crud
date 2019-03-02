package com.edward.springbootcrud.repository;

import com.edward.springbootcrud.bean.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTypeRespository extends JpaRepository<BookType,Integer> {

}
