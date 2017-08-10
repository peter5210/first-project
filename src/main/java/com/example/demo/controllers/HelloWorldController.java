package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Adder;
import com.example.demo.model.Whisperer;
import com.example.demo.model.Yeller;

@Controller
@RequestMapping({"/", "/HelloWorld"})
public class HelloWorldController {
	
	private String title;
	
	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}
	
	@GetMapping("")
	public String index() {
		return "helloworld/index";
	}
	
	@GetMapping("message")
	public ModelAndView message(@RequestParam(required=false, defaultValue="«silence»") String shoutMessage) {
			Yeller loud = new Yeller(shoutMessage);
		String result = loud.makeUpperCase();
		ModelAndView mv = new ModelAndView("helloworld/message");
		mv.addObject("title", title);
		mv.addObject("message", result);
		return mv;
	}
		
	@GetMapping("whisper")
	public ModelAndView whisper(@RequestParam(required=false, defaultValue="«shhhhh»") String silenceMessage) {
			Whisperer quiet = new Whisperer(silenceMessage);
		String result = quiet.makeLowerCase();
		ModelAndView mv = new ModelAndView("helloworld/whisper");
		mv.addObject("title", title);
		mv.addObject("whisper", result);
		return mv; 	
	}
	 
	@PostMapping("adder")
		public String addTwoNumbers(@RequestParam(name="left") int first, @RequestParam(name="right") double second, Model model) {
		Adder adder = new Adder(first, second);
		double result = adder.calculate();
		model.addAttribute("sum", result);
		return "helloworld/sum-result";
	}
	
}
