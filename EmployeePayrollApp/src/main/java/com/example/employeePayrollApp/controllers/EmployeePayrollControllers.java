package com.example.employeePayrollApp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeePayrollApp.dto.EmployeePayrollDTO;
import com.example.employeePayrollApp.dto.ResponseDTO;
import com.example.employeePayrollApp.model.EmployeePayrollData;
import com.example.employeePayrollApp.services.IEmployeePayrollService;
@RestController
@RequestMapping("/payrollservice")
public class EmployeePayrollControllers {
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	
	@GetMapping(value= {"","/","/get"})
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		List<EmployeePayrollData> empDataList = null;
		empDataList = employeePayrollService.getEmployeePayrollData();
		ResponseDTO respDTO = new ResponseDTO("Get Call Successful ",empDataList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrollData empData = null;
		empData =employeePayrollService.getEmployeePayrollDataById(empId);
		ResponseDTO respDTO = new ResponseDTO("Get Call for ID Successful ",empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		empData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully ",empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	

	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
			                                                     @Valid @RequestBody EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		empData = employeePayrollService.updateEmployeePayrollData(empId, empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully ",empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		employeePayrollService.deleteEmployeePayrollData(empId);
		ResponseDTO respDTO = new ResponseDTO("Deleted Successfully: ","Deleted id:"+empId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@GetMapping("/department/{department}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("department") String department) {
		List<EmployeePayrollData> empDataList = null;
		empDataList = employeePayrollService.getEmployeesByDepartment(department);
		ResponseDTO respDTO = new ResponseDTO("Get Call for Department Successful", empDataList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@GetMapping("/getByNameKeyword/{namekeyword}")
	public ResponseEntity<ResponseDTO> getAddressbookDataByNameKeyword(@PathVariable("namekeyword") String namekeyword){
		List<EmployeePayrollData> bookDataList = null;
		bookDataList = employeePayrollService.getEmployeePayrollDataByNameKeyword(namekeyword);
		ResponseDTO respDTO = new ResponseDTO("Get Call for get data by keyword", bookDataList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}