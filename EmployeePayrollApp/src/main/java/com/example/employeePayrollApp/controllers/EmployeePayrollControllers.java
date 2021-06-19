package com.example.employeePayrollApp.controllers;

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

@RestController
@RequestMapping("/payrollService")
public class EmployeePayrollControllers {
	
	// curl "localhost:8080/payrollService/" -w "\n"
	@RequestMapping(value= {"","/","/get"})
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1,new EmployeePayrollDTO("Lisa", 30000));
		ResponseDTO respDTO = new ResponseDTO("Get Call Successful ",empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	// curl "localhost:8080/payrollService/get/1" -w "\n"
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1,new EmployeePayrollDTO("Lisa", 30000));
		ResponseDTO respDTO = new ResponseDTO("Get Call for ID Successful ",empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/* curl -X POST -H "Content-Type:application/json" -d '{"name":"Lisa","salary":"30000"}'
	 * "http://localhost:8080/payrollService/create" -w "\n" */
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1, empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully ",empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/* curl -X PUT -H "Content-Type:application/json" -d '{"name":"Lisa","salary":"20000"}' 
	 * "http://localhost:8080/payrollService/update" -w "\n" */
	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1, empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully ",empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/*(curl -X DELETE -H "Content-Type:application/json" -d '{"name":"Lisa","salary":"20000"}' "http://localhost:8080/payrollService/delete/1" -w "\n") */
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		ResponseDTO respDTO = new ResponseDTO("Deleted Successfully: ","Deleted id:"+empId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
}
