package com.fullstackJavaApp.fullstackJavaApp.Controllers;

import com.fullstackJavaApp.fullstackJavaApp.Dto.EmployeeDto;
import com.fullstackJavaApp.fullstackJavaApp.Services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<EmployeeDto>(savedEmployee, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id){
        EmployeeDto employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<EmployeeDto>(employee, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees =  employeeService.getAllEmployees();
        return new ResponseEntity<List<EmployeeDto>>(employees, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(id, updatedEmployee);
        return new ResponseEntity<EmployeeDto>(employeeDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable("id") Long id){
        EmployeeDto deletedEmployee = employeeService.deleteEmployee(id);
        return new ResponseEntity<EmployeeDto>(deletedEmployee, HttpStatus.OK);
    }

}
