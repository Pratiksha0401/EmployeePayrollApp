package com.example.employeePayrollApp.model;

import com.example.employeePayrollApp.dto.EmployeePayrollDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeePayrollData {
	
	private int employeeId;
	private String name;
	private long salary;

	public EmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		this.employeeId = empId;
		this.name = empPayrollDTO.name;
		this.salary = empPayrollDTO.salary;
	}
	
}
