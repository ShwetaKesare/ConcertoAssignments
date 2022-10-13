package com.springbootassignment.LoanProposalSpringBootProject.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springbootassignment.LoanProposalSpringBootProject.model.Loan;

@Repository
public interface LoanRepository extends CrudRepository<Loan, String>{

	public List<Loan> findByEmployeeEmployeeId(String EmployeeId);
	public Optional<Loan> findByLoanId(String LoanId);
	
}
