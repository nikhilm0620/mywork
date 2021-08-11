package com.nk.springmvc;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController{

	
	@RequestMapping("/showForm")
	 public String showForm()
	 {
		return "helloworld-form";
		 
	 }
	
	@RequestMapping("/processForm")
	public String viewForm()
	{
		return "helloworld";
	}
	@RequestMapping("/processFormTwo")
	public String letsShoutOut(HttpServlet request,Model model)
	{
		String theName=request.getInitParameter("studentName");
		
		theName=theName.toUpperCase();
		
		String result="yo" + theName;
		
		model.addAttribute("message", result);
		
		return "Hello World"+result;
		
	}
	@RequestMapping("/processFormThree")
	public String letsShoutOut1(@RequestParam("studentName") String theName,Model model)
	{
		
		
		theName=theName.toUpperCase();
		
		String result="yo"+" " + theName;
		
		model.addAttribute("message", result);
		
		return "helloworld";
		
	}
}
