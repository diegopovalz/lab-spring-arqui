package com.udea.empleados.service;

import com.udea.empleados.exception.EmployeeNotFoundException;
import com.udea.empleados.exception.SalaryNotUpdatableException;
import com.udea.empleados.model.Employee;
import com.udea.empleados.repository.EmployeeRepository;
import com.udea.empleados.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    public Employee createOrUpdateEmployee(Employee employee) {
        this.employeeRepository.save(employee);
        return employee;
    }

    public boolean deleteEmployee(Long id) {
        boolean employeeExists = this.employeeRepository.existsById(id);
        if(!employeeExists) {
            throw new EmployeeNotFoundException("No existe empleado con id " + id);
        }
        this.employeeRepository.deleteById(id);
        return true;
    }

    public boolean checkForEmployeeSalaryUpdate(Long id) {
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("No existe empleado con id " + id));

        Date nowDate = new Date();
        Date employeeJoinedDate = employee.getJoinedDate();

        int yearsBetween = DateUtils.getDiffYears(nowDate, employeeJoinedDate);
        if(yearsBetween < 2) {
            throw new SalaryNotUpdatableException("El salario del empleado " + id + " no puede ser actualizado aún");
        }

        Double salary = employee.getSalary();
        salary *= 1.1; // Aumento del 10% sobre salario actual
        employee.setSalary(salary);

        this.employeeRepository.save(employee);
        return true;
    }
}
