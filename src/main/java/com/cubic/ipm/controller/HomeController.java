package com.cubic.ipm.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cubic.ipm.model.Role;
import com.cubic.ipm.util.SessionManager;

@Controller
@RequestMapping(value = "/")
public class HomeController {

	@RequestMapping
	public String home() {
		return "login";
	}
	
  	@RequestMapping(value="/login")
	public String loginPage() {
		return "login";
	}
  	
  	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public String loginDefaultPage(Model model,RedirectAttributes redirectAttributes) {
		String url = "";
		if (SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal() != null
				&& !SessionManager.isAnonymousUser()) {
			Role role = SessionManager.getRole();
			if (role.toString().equals(Role.ROLE_ADMIN.toString())) {
				url = "redirect:/admin";
			} else if (role.toString().equals(Role.ROLE_MARKETING.toString())) {
				url = "redirect:/marketer";
			} else if (role.toString().equals(Role.ROLE_VC.toString())) {
				url = "redirect:/vc";
			} else if (role.toString().equals(Role.ROLE_MASTERADMIN.toString())) {
				url = "redirect:/masteradmin";
			} else if (role.toString().equals(Role.ROLE_BCHECKER.toString())) {
				url = "redirect:/bchecker";
			}
		}

		return url;
	}
	
	@RequestMapping(value="/403")
	public String pageNotFound() {
		return "404";
	}
	
	@RequestMapping(value="/signup")
	public String signUpPage (){
		return "signup";
	}
	
	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String auth_failed(Model model) {
		String url = "";
		try {
			model.addAttribute("error", "Invalid username and password.");
			url = "login";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model) {
 		return "login";
 	}
	
	@RequestMapping(value="/error-forbidden", method = RequestMethod.GET)
	public String accessDenied() {
		return "error-forbidden" ;
    }
	
	@RequestMapping({ "/masteradmin","/admin", "/marketer", "/vc", "/bchecker"})
	public String myDashboard(Model model) {
		model.addAttribute("user", SessionManager.getAuthenticatedPriniciapl());
		model.addAttribute("role", SessionManager.getRole().toString());
		return "admin/dashboard";
	}

}
