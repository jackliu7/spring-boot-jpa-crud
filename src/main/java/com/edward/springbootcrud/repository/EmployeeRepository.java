package com.edward.springbootcrud.repository;

import com.edward.springbootcrud.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
