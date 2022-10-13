package com.springbootassignment.LoanProposalSpringBootProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springbootassignment.LoanProposalSpringBootProject.model.Collateral;

@Repository
public interface CollateralRepository extends CrudRepository<Collateral, String>{

}
