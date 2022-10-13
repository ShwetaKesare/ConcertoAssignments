package com.springbootassignment.LoanProposalSpringBootProject.springservice;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootassignment.LoanProposalSpringBootProject.model.Collateral;
import com.springbootassignment.LoanProposalSpringBootProject.model.Customer;
import com.springbootassignment.LoanProposalSpringBootProject.model.Employee;
import com.springbootassignment.LoanProposalSpringBootProject.model.Loan;
import com.springbootassignment.LoanProposalSpringBootProject.repository.CollateralRepository;
import com.springbootassignment.LoanProposalSpringBootProject.repository.CustomerRepository;
import com.springbootassignment.LoanProposalSpringBootProject.repository.EmployeeRepository;
import com.springbootassignment.LoanProposalSpringBootProject.repository.LoanRepository;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepository; 
	
	@Autowired
	private CollateralRepository collateralRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
public Loan findLoanById(String loanId) {
		
	Loan loan = null;	
		
		Optional<Loan> opt = this.loanRepository				
				.findById(loanId);
				
		loan = opt.get();
		return loan;		
	}
	
public boolean uploadCollateral(String loanId,List<String> collateralIds)
{
	Optional<Loan> opt = this.loanRepository.findById(loanId);	
	
	opt.ifPresent(loan->{
		List<Collateral> collaterals = new ArrayList<Collateral>();
		
		collateralIds.forEach(id->{
			collaterals.add(this.collateralRepository.findById(id).get());
		});
		
		loan.setCollaterals(collaterals);
		this.loanRepository.save(loan);
		
	});
	
	return true;	
}

public boolean applyForLoan(String loanType,double loanAmount,double period, String email)
{
	System.out.println("applyforloan-loanservice");
	Loan loan = new Loan();
	
	loan.setLoanId(loanType);
	loan.setLoanAmount(loanAmount);
	loan.setLoanperiod(period);		
	
	Customer customer = new Customer();
	customer.setCustomerEmailId(email);
	loan.setCustomer(customer);//customerRepository.findById(email).get()
	
	loan.setInterestRate(com.springbootassignment.LoanProposalSpringBootProject.constants.LoanConstants.calculateRate(period));
	
	loan.setLoanType(loanType);
	loan.setLoanAmount(loanAmount);
	
	int index = (int)(Math.random()* (employeeRepository.count()));
	System.out.println("index "+index);
	List<Employee> emps = new ArrayList<>();
	this.employeeRepository.findAll().forEach(emp->emps.add(emp));
	loan.setEmployee(emps.get(index));
	loan.setLoanId("SB_LN_000"+(this.loanRepository.count()+1)+"_"+email);
	loanRepository.save(loan);
	return true;

}
}
