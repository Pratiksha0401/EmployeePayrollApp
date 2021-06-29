package com.example.employeePayrollApp.services;

import java.util.List;

import com.example.employeePayrollApp.dto.EmployeePayrollDTO;
import com.example.employeePayrollApp.model.EmployeePayrollData;

public interface IEmployeePayrollService {
	List<EmployeePayrollData> getEmployeePayrollData();
	EmployeePayrollData getEmployeePayrollDataById(int empId);
	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);
	EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO);
	void deleteEmployeePayrollData(int empId);
	List<EmployeePayrollData> getEmployeesByDepartment(String department);
	List<EmployeePayrollData> getEmployeePayrollDataByNameKeyword(String namekeyword);
}
