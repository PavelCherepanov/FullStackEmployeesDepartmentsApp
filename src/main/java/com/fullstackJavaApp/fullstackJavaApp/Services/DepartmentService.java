package com.fullstackJavaApp.fullstackJavaApp.Services;

import com.fullstackJavaApp.fullstackJavaApp.Dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto);
    List<DepartmentDto> getAllDepartments();
    DepartmentDto getDepartmentById(Long id);
    DepartmentDto removeDepartment(Long id);
}
