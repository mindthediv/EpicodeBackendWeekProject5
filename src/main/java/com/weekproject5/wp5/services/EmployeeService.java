package com.weekproject5.wp5.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weekproject5.wp5.models.Employee;
import com.weekproject5.wp5.repositories.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired public EmployeeRepo employeeRepo;

    public void save(Employee e){
        employeeRepo.save(e);
    }
    public void saveAndFlush(Employee e){
        employeeRepo.saveAndFlush(e);
    }
    public void update(Employee e){
        employeeRepo.save(e);
    }
    public void delete(Employee e){
        employeeRepo.delete(e);
    }
    public Optional<Employee> findById(long id){
        return employeeRepo.findById(id);
    }
    public Employee post(String un, String fn, String email) {
        Employee e = new Employee(un, fn, email);
        employeeRepo.saveAndFlush(e);
        return e;
    }
    
}
