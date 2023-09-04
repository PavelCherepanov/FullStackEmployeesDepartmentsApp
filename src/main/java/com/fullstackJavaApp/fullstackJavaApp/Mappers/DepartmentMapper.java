package com.fullstackJavaApp.fullstackJavaApp.Mappers;

import com.fullstackJavaApp.fullstackJavaApp.Dto.DepartmentDto;
import com.fullstackJavaApp.fullstackJavaApp.Models.Department;

public class DepartmentMapper {
    //convert department jpa into dto
    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }

    public static Department mapToDepartment(DepartmentDto departmentDto){
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );
    }
}
