package com.springbootassignment.LoanProposalSpringBootProject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntityNotFoundException extends Exception{

	public String message;	
}
