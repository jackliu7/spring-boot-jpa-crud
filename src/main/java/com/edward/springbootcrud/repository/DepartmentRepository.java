package com.edward.springbootcrud.repository;

import com.edward.springbootcrud.bean.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
