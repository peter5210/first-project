package com.example.demo.model;

public class Remainder {

double sum; 
	
	public Remainder(int first, double second) {
		sum = first % second;
	}
		
	public double calculate() {
		return sum;
	}
}
