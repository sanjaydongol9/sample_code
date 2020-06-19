package com.cubic.ipm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cubic.ipm.util.SessionManager;

@Controller
@RequestMapping("/marketing")
public class MarketingController {
	
	@RequestMapping
	public String myDashboard(Model model) {
		model.addAttribute("user", SessionManager.getAuthenticatedPriniciapl());
		model.addAttribute("role", SessionManager.getRole().toString());
		return "marketing/dashboard";
	}
	
}
