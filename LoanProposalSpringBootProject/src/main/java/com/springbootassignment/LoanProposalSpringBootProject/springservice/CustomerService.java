package com.springbootassignment.LoanProposalSpringBootProject.springservice;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootassignment.LoanProposalSpringBootProject.model.Collateral;
import com.springbootassignment.LoanProposalSpringBootProject.model.Customer;
import com.springbootassignment.LoanProposalSpringBootProject.repository.CollateralRepository;
import com.springbootassignment.LoanProposalSpringBootProject.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CollateralRepository collateralRepository;

	
	public Customer findCustomerByEmail(String custemail) {
		
		Customer customer = null;
		System.out.println("Customer email "+custemail);
		
		Optional<Customer> opt = this.customerRepository				
				.findById(custemail);
				//.orElseThrow()-> new EntityNotFoundException("Customer with id: "+custemail+" not found");
				
		customer = opt.get();
		return customer;		
	}
	
	@Transactional
	public boolean addCustomer(Customer customer) {
		
		Customer savedCustomer = this.customerRepository.save(customer);
		return true;		
	}
	
	
	@Transactional
	public boolean addCollateral(Collateral collateral)
	{
		System.out.println(collateral.getCollateral_Id()+" "+collateral.getCollateral_Type());
		Collateral savedcollateral=this.collateralRepository.save(collateral);		
		return true;
		
	}

}
