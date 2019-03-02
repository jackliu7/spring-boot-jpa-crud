package com.edward.springbootcrud.repository;

import com.edward.springbootcrud.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
     User findByNameAndAndPassword(String name, String password);
}
