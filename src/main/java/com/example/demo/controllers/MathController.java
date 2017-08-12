package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Adder;
import com.example.demo.model.Divide;
import com.example.demo.model.Exponent;
import com.example.demo.model.Multiply;
import com.example.demo.model.Remainder;
import com.example.demo.model.Subtractor;

@Controller
@RequestMapping("/math")
public class MathController {

	//adding
	@PostMapping("calculator")
	public ModelAndView mathTwoNumbers(@RequestParam(name = "left") int first, @RequestParam(name = "right") double second, @RequestParam(name = "mathChoice") String mathChoice, Model model) {
		
		Double result = null;
		
		if(mathChoice.equals("+")) {
			Adder adder = new Adder(first, second);
			result = adder.calculate();	
		} else if (mathChoice.equals("-")) {
			Subtractor subtract = new Subtractor(first, second);
			result = subtract.calculate();	
		} else if (mathChoice.equals("/")) {
			Divide divide = new Divide(first, second);
			result = divide.calculate();	
		} else if (mathChoice.equals("*")) {	
			Multiply multiply = new Multiply(first, second);
			result = multiply.calculate();	
		} else if (mathChoice.equals("%")) {	
			Remainder remainder = new Remainder(first, second);
			result = remainder.calculate();	
		} else {	
			Exponent exponent = new Exponent(first, second);
			result = exponent.calculate();	
			}
	
		ModelAndView mv = new ModelAndView("math/calculator-result");
		mv.addObject("sum", result); 
		return mv;
	}
	

	@GetMapping("calculator")
	public String adder() {
		return "math/calculator";
	}
	
}	