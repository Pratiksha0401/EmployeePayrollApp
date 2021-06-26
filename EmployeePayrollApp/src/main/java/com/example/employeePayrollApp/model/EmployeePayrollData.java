package com.example.employeePayrollApp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.example.employeePayrollApp.dto.EmployeePayrollDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_payroll")
@Data
@NoArgsConstructor
public class EmployeePayrollData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employeeId;
	private String name;
	private long salary;
	public String gender;
	public LocalDate startDate;
	public String note;
	public String profilePic;
	
	@ElementCollection
	@CollectionTable(name="employee_department", joinColumns=@JoinColumn(name="id"))
	@Column(name = "department")
	public List<String> departments; 

	public EmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		this.updateEmployeePayrollData(empPayrollDTO);
	}
	
	private void updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		
	}
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
