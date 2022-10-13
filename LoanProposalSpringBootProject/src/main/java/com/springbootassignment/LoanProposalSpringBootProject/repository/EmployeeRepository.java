package com.springbootassignment.LoanProposalSpringBootProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springbootassignment.LoanProposalSpringBootProject.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String>{

}
