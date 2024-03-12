package net.javaguides.SpringbootBackend.service.impl;

import net.javaguides.SpringbootBackend.exception.ResourceNotFoundException;
import net.javaguides.SpringbootBackend.model.Employee;
import net.javaguides.SpringbootBackend.repository.EmployeeRepository;
import net.javaguides.SpringbootBackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {

        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        //first we need to check if the employee is present in the DB

        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Employee", "id",id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setSecondName(employee.getSecondName());
        existingEmployee.setEmailId(employee.getEmailId());
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        //we need to handle non existing entries
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Employee", "id",id));

        employeeRepository.deleteById(id);
    }


}
