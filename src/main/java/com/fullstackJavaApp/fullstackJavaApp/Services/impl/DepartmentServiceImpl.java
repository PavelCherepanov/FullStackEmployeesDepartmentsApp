package com.fullstackJavaApp.fullstackJavaApp.Services.impl;

import com.fullstackJavaApp.fullstackJavaApp.Dto.DepartmentDto;
import com.fullstackJavaApp.fullstackJavaApp.Exceptions.ResourceNotFoundException;
import com.fullstackJavaApp.fullstackJavaApp.Mappers.DepartmentMapper;
import com.fullstackJavaApp.fullstackJavaApp.Models.Department;
import com.fullstackJavaApp.fullstackJavaApp.Repositories.DepartmentRepository;
import com.fullstackJavaApp.fullstackJavaApp.Services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with id " + id));
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        Department updatedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(updatedDepartment);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department) ->
                DepartmentMapper.mapToDepartmentDto(department)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department is not exists with id " + id));
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public DepartmentDto removeDepartment(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department is not exists with id " + id));
        departmentRepository.delete(department);
        return DepartmentMapper.mapToDepartmentDto(department);
    }
}
