package com.example.employeePayrollApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeePayrollApp.model.EmployeePayrollData;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer>{

}
