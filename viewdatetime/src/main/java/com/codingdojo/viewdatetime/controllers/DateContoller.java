package com.codingdojo.viewdatetime.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

@Controller
public class DateContoller {

	@RequestMapping("/")
	public String index() {		
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E, dd 'de' MMMM, yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		String date = dtf.format(now);
		date = date.replace(".", "");
		model.addAttribute("date",date);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm a");  
		LocalDateTime now = LocalDateTime.now();  
		String time = dtf.format(now);
		model.addAttribute("time",time);
		return "time.jsp";
	}
	
}
