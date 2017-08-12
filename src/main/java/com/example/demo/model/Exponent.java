package com.example.demo.model;

public class Exponent {

	double sum; 
	
	public Exponent(int first, double second) {
		sum = Math.pow(first, second);
	}
	
	
	public double calculate() {
		return sum;
	}
}
