package com.fpt.edu.springbootcrud.controller;

import com.fpt.edu.springbootcrud.model.Employee;
import com.fpt.edu.springbootcrud.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class employeeController {
    @Autowired
    private IEmployeeService employeeService;
    @GetMapping("")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
    @PostMapping("")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployee(id);
    }
    @GetMapping("/search")
    public List<Employee> searchEmployees(@RequestParam String name) {
        return employeeService.searchEmployee(name);
    }
}
