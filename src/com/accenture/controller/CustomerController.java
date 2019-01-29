package com.accenture.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.model.Customer;
import com.accenture.service.CustomerService;

@Controller
public class CustomerController {

	@RequestMapping(value="/addCustomer", method=RequestMethod.POST)
	public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response) {
		
		String cname= request.getParameter("customerName");
		String cmail= request.getParameter("email");
		String cphone=request.getParameter("phone");
		int rows=0;
		
		Customer customer= new Customer();
		
		customer.setCustomerName(cname);
		customer.setEmail(cmail);
		customer.setPhone(cphone);
		
		CustomerService customerService= new CustomerService();
		rows=customerService.addCustomer(customer);
		
		ModelAndView mv= new ModelAndView();
		
		if(rows!=0)
		{
		String data="Inserted Successfully";
		mv.addObject("REGSTATUS", data);
		mv.setViewName("registration.jsp");
		}
		else
		{
			String data="Not Inserted Successfully";
			mv.addObject("REGSTATUS", data);
			mv.setViewName("registration.jsp");
		}
		
		return mv;
	}
}
