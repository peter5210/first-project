package com.example.demo.model;

public class Yeller {
	
	String upperCase1;
	
	public Yeller(String message){
		upperCase1 = message;
		}

	public String makeUpperCase() {
		return upperCase1.toUpperCase();
		}
}
