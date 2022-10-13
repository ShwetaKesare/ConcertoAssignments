package com.springbootassignment.LoanProposalSpringBootProject.springservice;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootassignment.LoanProposalSpringBootProject.model.Customer;
import com.springbootassignment.LoanProposalSpringBootProject.model.Employee;
import com.springbootassignment.LoanProposalSpringBootProject.model.Loan;
import com.springbootassignment.LoanProposalSpringBootProject.repository.CustomerRepository;
import com.springbootassignment.LoanProposalSpringBootProject.repository.EmployeeRepository;
import com.springbootassignment.LoanProposalSpringBootProject.repository.LoanRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private LoanRepository loanRepository;
	
	public void approveLoan(String empemail)
	{
		List<Loan> loanList= this.loanRepository.findByEmployeeEmployeeId(empemail);
		
		for(Loan loan:loanList)
		{
			Customer customer=loan.getCustomer();			
			
			if(loan.getLoanAmount()>10*customer.getAnnualIncome())//Loan amount cannot be 10 times of annual income
			{
				loan.setApproved(false);
				this.loanRepository.save(loan);
			}
			else if(loan.getCollaterals()==null)//No collateral submitted
			{
				loan.setApproved(false);
				this.loanRepository.save(loan);
			}			
			else if(customer.isIncomeTaxReturnAttached()==false)//Income proof not attached
			{
				loan.setApproved(false);
				this.loanRepository.save(loan);
			}
			else if(customer.getCustomerIdentity()==null)//Identity document not submitted
			{
				loan.setApproved(false);
				this.loanRepository.save(loan);
			}
			else
			{
				loan.setApproved(true);
				this.loanRepository.save(loan);				
			}
		}
	}
	
	public boolean searchEmployeeById(String eid) {		
		
		Optional<Employee> opt = this.employeeRepository				
				.findById(eid);
		if(opt.isPresent())		
		{
			return true;
		}
		else
		{
			return false;
		}			
	}
	
	@Transactional
	public boolean addEmployee(Employee employee) {
		
		Employee savedEmployee = this.employeeRepository.save(employee);
		return true;		
	}

}
