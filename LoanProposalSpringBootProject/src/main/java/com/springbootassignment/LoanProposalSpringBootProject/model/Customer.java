package com.springbootassignment.LoanProposalSpringBootProject.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name="Shweta_Customer")
public class Customer {
	
	@Id
	private String customerEmailId;
	private String customerName; 	
	private String customerAddress;		
	private String customerIdentity;
	private double annualIncome;
	private boolean incomeTaxReturnAttached;
	
	//Loan And Customer One to One Relationship 
	//Customer's customerIdentity column saved in loan table as foreign key
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="customer")
	private Loan loan;


}
