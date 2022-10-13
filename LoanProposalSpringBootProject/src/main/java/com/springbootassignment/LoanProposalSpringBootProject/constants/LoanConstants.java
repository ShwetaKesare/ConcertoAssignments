package com.springbootassignment.LoanProposalSpringBootProject.constants;

import java.util.ArrayList;

import com.springbootassignment.LoanProposalSpringBootProject.model.Collateral;

public class LoanConstants {

	
	public static final  ArrayList<Collateral> COLLATERAL_TYPE = new ArrayList<Collateral>();	
	
	public static final String LOAN_TYPE[]={"Buying home","Vehicle","education","Marriage","hospitalization"};
	public static final String ID_TYPE[]={"Passport","driving license","aadhar card"};
	
	public static final String LOANTABLE = "LOAN";
	public static final String CUSTOMERTABLE = "CUSTOMER";
	public static final String EMPLOYEETABLE = "EMPLOYEE";
	public static final String LOANCOLLATERALTABLE = "LOAN_COLLATERAL";
	public static final String COLLATERALTABLE = "COLLATERAL";
	
	
	public static double calculateRate(double loanTerm)
	{

		double interestRate=0;
		
		if(loanTerm<=2)
		{
			interestRate=0.05;
		}
		else if(loanTerm>2 && loanTerm<=5)
		{
			interestRate=0.06;
		}
		else if(loanTerm>5 && loanTerm<=8)
		{
			interestRate=0.08;
		}
		else if(loanTerm>8)
		{
			interestRate=0.085;
		}

		return interestRate;
	}
}
