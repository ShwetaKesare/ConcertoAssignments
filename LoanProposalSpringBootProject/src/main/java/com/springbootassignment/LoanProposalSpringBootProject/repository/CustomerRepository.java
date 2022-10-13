package com.springbootassignment.LoanProposalSpringBootProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springbootassignment.LoanProposalSpringBootProject.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer, String>{

}
