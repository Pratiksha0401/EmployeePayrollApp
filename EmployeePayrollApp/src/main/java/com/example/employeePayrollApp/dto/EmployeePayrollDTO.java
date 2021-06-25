package com.example.employeePayrollApp.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message="Employee Name Invalid")
	public String name;
	
	@Min(value=500, message="Min wage should be more than 500")
	public long salary;
	
}
