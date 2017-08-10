package com.example.demo.model;

public class Whisperer {

String lowerCase1;
	
	public Whisperer(String message){
		lowerCase1 = message;
		}

	public String makeLowerCase() {
		return lowerCase1.toLowerCase();
		}
}

