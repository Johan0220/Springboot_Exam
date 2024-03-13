package com.fpt.edu.springbootcrud.service;

import com.fpt.edu.springbootcrud.model.Employee;
import com.fpt.edu.springbootcrud.repostiory.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IEmployeeImpl implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        if(employee != null){
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        if(employee != null){
            Employee employee1= employeeRepository.getById(id);
            if(employee1!=null){
                employee1.setName(employee.getName());
                employee1.setAge(employee.getAge());
                employee1.setSalary(employee.getSalary());
                return employeeRepository.save(employee1);
            }
        }
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        if(id >= 1){
            Employee employee = employeeRepository.getReferenceById(id);
            if(employee != null) {
                employeeRepository.delete(employee);
            }
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> searchEmployee(String name){
        return employeeRepository.findByNameContaining(name);
    }

}
