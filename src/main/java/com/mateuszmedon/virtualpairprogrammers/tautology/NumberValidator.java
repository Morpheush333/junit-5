package com.mateuszmedon.virtualpairprogrammers.tautology;

public class NumberValidator {

	public boolean isItPrime(int number) {
		number = Math.abs(number);
		if (number <= 1) return false;
		int maxDivisor = (int)Math.sqrt(number); 
		for(int i=2;i<=maxDivisor;i++) {
	        if(number % i==0)
	            return false;
	    }
	    return true;
	}

	
}
