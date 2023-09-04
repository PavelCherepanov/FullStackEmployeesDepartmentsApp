package com.fullstackJavaApp.fullstackJavaApp.Services;

import com.fullstackJavaApp.fullstackJavaApp.Dto.EmployeeDto;
import com.fullstackJavaApp.fullstackJavaApp.Models.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long id, EmployeeDto updateEmployee);
    EmployeeDto deleteEmployee(Long id);
}
