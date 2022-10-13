package com.springbootassignment.LoanProposalSpringBootProject.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springbootassignment.LoanProposalSpringBootProject.model.Loan;
import com.springbootassignment.LoanProposalSpringBootProject.springservice.LoanService;

@RestController
@RequestMapping//("/loan")
public class LoanRestController {
	
	@Autowired
	private LoanService loanService;
	
	@GetMapping("/findLoan/{loanid}")
	public Loan getLoanById(@PathVariable String loanid)
	{
		return this.loanService.findLoanById(loanid);
	}
	
	@PostMapping("/uploadCollaterals/{loanid}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<String> uploadCollateral(@PathVariable String loanid,@RequestParam List<String> ids)
	{
		System.out.println(ids);
		System.out.println(loanid);
		 if(this.loanService.uploadCollateral(loanid, ids))
			 return ResponseEntity.status(HttpStatus.CREATED)
					 .body("Collaterals Updated successfully");
		 return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
				 .body("Collaterals were not updated");

	}
	
	@PostMapping("/applyloan/{email}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<String> applyLoan(
		@RequestBody Loan loan,@PathVariable String email)//, 
	{
		System.out.println("applyforloan-loancontroller");
		
		this.loanService.applyForLoan(loan.getLoanType(), loan.getLoanAmount(), loan.getLoanperiod(), email);
		return ResponseEntity.status(HttpStatus.CREATED).body("apply for loan successfully");
	}


}
