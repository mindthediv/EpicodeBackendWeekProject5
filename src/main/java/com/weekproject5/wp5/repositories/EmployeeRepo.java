package com.weekproject5.wp5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.weekproject5.wp5.models.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{
    
}
