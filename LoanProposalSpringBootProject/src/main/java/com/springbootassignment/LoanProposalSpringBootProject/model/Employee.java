package com.springbootassignment.LoanProposalSpringBootProject.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
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
//@Table(name="Shweta_Employee")
public class Employee {
	
	@Id
	private String employeeId;
	private String employeeName;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="employee")
	private Loan loan;

}
