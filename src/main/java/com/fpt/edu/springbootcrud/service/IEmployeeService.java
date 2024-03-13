package com.fpt.edu.springbootcrud.service;

import com.fpt.edu.springbootcrud.model.Employee;

import java.util.List;

public interface IEmployeeService {
    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(Long id, Employee employee);
    public void deleteEmployee(Long id);
    public List<Employee> getAllEmployee();
    public List<Employee> searchEmployee(String name);

}

