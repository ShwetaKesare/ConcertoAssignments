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

import com.springbootassignment.LoanProposalSpringBootProject.model.Collateral;
import com.springbootassignment.LoanProposalSpringBootProject.model.Customer;
import com.springbootassignment.LoanProposalSpringBootProject.springservice.CustomerService;


@RestController
@RequestMapping//("/customer")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/findCustomer/{custemail}")
	public Customer findCustomerByEmail(@PathVariable String custemail) 
	{
		return this.customerService.findCustomerByEmail(custemail);
	}
	
	@PostMapping("/addCustomer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer)
	{
		try {
			this.customerService.addCustomer(customer);
			return ResponseEntity.status(HttpStatus.CREATED).body("Customer Created successfully");
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer creation failed");
		}		
	}
	
	@PostMapping("/addCollateral")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<String> addCollateral(@RequestBody Collateral collateral)
	{
		try {
			this.customerService.addCollateral(collateral);
			return ResponseEntity.status(HttpStatus.CREATED).body("Collateral Added successfully");
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("addition failed");
		}		
	}
	
}
