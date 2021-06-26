package com.example.employeePayrollApp.model;

import java.util.List;

import com.example.employeePayrollApp.dto.EmployeePayrollDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeePayrollData {
	
	private int employeeId;
	private String name;
	private long salary;
	public String gender;
	public String startDate;
	public String note;
	public String profilePic;
	public List<String> departments; 

	public EmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		this.employeeId = empId;
		this.name = empPayrollDTO.name;
		this.salary = empPayrollDTO.salary;
		this.gender = empPayrollDTO.gender;
		this.note  = empPayrollDTO.note;
		this.startDate = empPayrollDTO.startDate;
		this.profilePic = empPayrollDTO.profilePic;
		this.departments = empPayrollDTO.departments;	
	}
	
}
