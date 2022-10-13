package com.springbootassignment.LoanProposalSpringBootProject.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



import com.springbootassignment.LoanProposalSpringBootProject.model.Employee;
import com.springbootassignment.LoanProposalSpringBootProject.springservice.EmployeeService;



@RestController
@RequestMapping
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee)
	{
		try {
			this.employeeService.addEmployee(employee);
			return ResponseEntity.status(HttpStatus.CREATED).body("Employee Created successfully");
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee creation failed");
		}		
	}
	
	@GetMapping("/findEmployee/{empemail}")
	public boolean searchEmployeeById(@PathVariable String empemail) 
	{
		return this.employeeService.searchEmployeeById(empemail);
	}

	@PostMapping("/approveLoan/{empemail}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<String> approveLoan(@PathVariable String empemail)
	{		
		try {
			System.out.println("approveloan-empcontroller");
			this.employeeService.approveLoan(empemail);
		}
		catch(Exception e )
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Loan approval process failed");
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Loan approval process done");		
	}
}
