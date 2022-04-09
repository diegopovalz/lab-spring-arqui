package com.udea.empleados.controller;

import com.udea.empleados.model.Employee;
import com.udea.empleados.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<Employee> employees = this.employeeService.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id) {
        boolean deleted = this.employeeService.deleteEmployee(id);
        return new ResponseEntity<>(deleted, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        employee = this.employeeService.createOrUpdateEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        employee = this.employeeService.createOrUpdateEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/{id}/updateSalary")
    public ResponseEntity<?> checkForEmployeeSalaryUpdate(@PathVariable Long id) {
        boolean salaryUpdated = this.employeeService.checkForEmployeeSalaryUpdate(id);
        return new ResponseEntity<>(salaryUpdated, HttpStatus.NO_CONTENT);
    }
}
