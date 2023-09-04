package com.fullstackJavaApp.fullstackJavaApp.Services.impl;

import com.fullstackJavaApp.fullstackJavaApp.Dto.EmployeeDto;
import com.fullstackJavaApp.fullstackJavaApp.Exceptions.ResourceNotFoundException;
import com.fullstackJavaApp.fullstackJavaApp.Mappers.EmployeeMapper;
import com.fullstackJavaApp.fullstackJavaApp.Models.Department;
import com.fullstackJavaApp.fullstackJavaApp.Models.Employee;
import com.fullstackJavaApp.fullstackJavaApp.Repositories.DepartmentRepository;
import com.fullstackJavaApp.fullstackJavaApp.Repositories.EmployeeRepository;
import com.fullstackJavaApp.fullstackJavaApp.Services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private DepartmentRepository departmentRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Department department = departmentRepository.findById(employeeDto.getDepartmentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department is not exists with id: " + employeeDto.getDepartmentId()));


        employee.setDepartment(department);
        System.out.println("cdsdddddddddddddddddddddddddd");
        System.out.println(employeeDto.toString());
//        employee.setEmail("csdcsdcsdcdcscff");
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with id " + id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with id " + id));
        employeeRepository.deleteById(id);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: " + id)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Department department = departmentRepository.findById(updatedEmployee.getDepartmentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department is not exists with id: " + updatedEmployee.getDepartmentId()));

        employee.setDepartment(department);

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }
}
