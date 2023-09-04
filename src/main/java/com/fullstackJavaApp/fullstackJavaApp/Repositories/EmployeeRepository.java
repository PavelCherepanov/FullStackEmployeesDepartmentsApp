package com.fullstackJavaApp.fullstackJavaApp.Repositories;

import com.fullstackJavaApp.fullstackJavaApp.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
