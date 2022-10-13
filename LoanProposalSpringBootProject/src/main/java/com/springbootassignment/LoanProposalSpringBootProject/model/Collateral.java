package com.springbootassignment.LoanProposalSpringBootProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name="Shweta_Collateral")
public class Collateral {

	@Id
	private String collateral_Id;
	private String collateral_Type;
	
//	@ManyToOne
//	@JoinColumn(name="Loan_Id")
//	private Loan loan;

}
