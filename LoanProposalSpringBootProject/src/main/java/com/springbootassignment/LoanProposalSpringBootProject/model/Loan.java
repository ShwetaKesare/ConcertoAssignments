package com.springbootassignment.LoanProposalSpringBootProject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loan {
	
	@Id
	private String loanId;
	private String loanType;
	private double loanAmount;
	private double interestRate;
	private double loanperiod;
	private boolean isApproved=false;
	
	@OneToOne
	@JoinColumn(name="Cust_Id")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="Emp_Id")
	private Employee employee;
	
	@ManyToMany
	@JoinTable(
			name= "LOAN_COLLATERAL",
			joinColumns = { @JoinColumn(name = "loanId") }, 
			inverseJoinColumns = { @JoinColumn(name = "collateral_Id") }
			)
	private List<Collateral> collaterals;	

}
