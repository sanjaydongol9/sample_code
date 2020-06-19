package com.cubic.ipm.controller;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cubic.ipm.dto.PrivilegeControlDto;
import com.cubic.ipm.dto.TreeViewDto;
import com.cubic.ipm.model.Candidate;
import com.cubic.ipm.model.Proxy;
import com.cubic.ipm.model.Role;
import com.cubic.ipm.model.Technology;
import com.cubic.ipm.model.User;
import com.cubic.ipm.model.UserControl;
import com.cubic.ipm.service.CandidateService;
import com.cubic.ipm.service.ProxyService;
import com.cubic.ipm.service.TechnologyService;
import com.cubic.ipm.service.UserService;


//@RestController
@Controller
//@RequestMapping("/admin")
//@ResponseStatus(HttpStatus.OK)
public class AdminController {
	
	private Logger logger = Logger.getLogger(AdminController.class); 
	
	@Autowired
	private UserService userService;

	@Autowired
	private ProxyService proxyService;
	
	@Autowired
	private TechnologyService technologyService;
	
	@Autowired
	private CandidateService candidateService;

	@RequestMapping(value = "/admin/create-user", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody User createUser(@RequestBody User user) {
		logger.info("+++++ Creating the User ++++++"+ user.getDob());
			userService.createUser(user);
		return user;
	}

	@RequestMapping(value = "admin/roles", method = RequestMethod.GET)
	public @ResponseBody Role[] roles() {
		return Role.values();
	}



	@RequestMapping(value ="/admin/test", method = RequestMethod.POST)
	public @ResponseBody Technology testMe(@RequestBody Technology technology) {
		logger.info("+++++ Creating the User ++++++");
//		userService.createUser(user);
		return technology;
	}

	@RequestMapping(value = "/admin/test1", method = RequestMethod.POST)
	public @ResponseBody Technology testMe1(@RequestBody String name) {
		logger.info("+++++ Creating the User ++++++");
//		userService.createUser(user);
		Technology technology = new Technology(); 
		technology.setId(1l);
		technology.setName("Java");
		return technology;
	}

	@RequestMapping(value = "admin/addproxy", method = RequestMethod.POST)
	public @ResponseBody Proxy addproxy(@RequestBody Proxy proxy) {
		logger.info("+++++ Adding Proxy +++++");
		proxy.setTechnology(technologyService.findTechnologyById(proxy.getTechnology().getId()));
		proxyService.createProxy(proxy);
		
		return proxy;
	}



	
	@RequestMapping(value = "admin/vc_candidates", method = RequestMethod.GET)
	public @ResponseBody PrivilegeControlDto getVcCandidates() {
		logger.info("+++++ Getting Vendor Call Taker and Candidates +++++");
		PrivilegeControlDto privilegeControlDto = new PrivilegeControlDto();
		
	/*	HashMap<User, List<Candidate>> vendorCallTaker = new HashMap<>();
		User user = new User(); 
		user.setId(1l);
		user.setUsername("Suren");
		user.setFirstName("Surendra");
		user.setLastName("Bahadur");
		user.setRole(Role.ROLE_VC);
		List<Candidate> candidates = new ArrayList<>(); 
		Candidate candidate = new Candidate(); 
		candidate.setId(1L);
		candidate.setFirstName("Rakesh");
		candidate.setLastName("Lamsal");
		candidates.add(candidate); 
		
		candidate = new Candidate(); 
		candidate.setId(2L);
		candidate.setFirstName("Jeka");
		candidate.setLastName("Don");
		candidates.add(candidate);
		
		candidate = new Candidate(); 
		candidate.setId(1L);
		candidate.setFirstName("Dipendra");
		candidate.setLastName("Chhetri");
		candidates.add(candidate);
		vendorCallTaker.put(user, candidates);
		
		//2nd Vendor
		user = new User(); 
		user.setId(2l);
		user.setUsername("Madan");
		user.setFirstName("Surendra");
		user.setLastName("Jnawali");
		user.setRole(Role.ROLE_VC);
		candidates = new ArrayList<>(); 
		candidate = new Candidate(); 
		candidate.setId(3L);
		candidate.setFirstName("Laxman");
		candidate.setLastName("Gyawali");
		candidates.add(candidate); 
		
		candidate = new Candidate(); 
		candidate.setId(4L);
		candidate.setFirstName("Hari");
		candidate.setLastName("Prasad");
		candidates.add(candidate);
		
		candidate = new Candidate(); 
		candidate.setId(5L);
		candidate.setFirstName("Ram");
		candidate.setLastName("Chandra");
		candidates.add(candidate);
		vendorCallTaker.put(user, candidates);
		
		//Duplicate Vendor
		user = new User(); 
		user.setId(2l);
		user.setUsername("Madan");
		user.setRole(Role.ROLE_VC);
		candidates = new ArrayList<>(); 
		candidate = new Candidate(); 
		candidate.setId(6L);
		candidate.setFirstName("Gyanau");
		candidate.setLastName("Thapa");
		candidates.add(candidate); 
		vendorCallTaker.put(user, candidates);
		privilegeControlDto.setVendorCallTakers(vendorCallTaker);*/
		
		privilegeControlDto = userService.getVcCandidates();
		return privilegeControlDto;
	}
	
	
	@RequestMapping(value = "admin/vc_candidates", method = RequestMethod.POST)
	public @ResponseBody PrivilegeControlDto manageVcCandidates(@RequestBody PrivilegeControlDto privilegeControlDto) {
		logger.info("+++++ Setting the role of vc candidates +++++");
		
		userService.manageVcCandidates(privilegeControlDto);
		
		return privilegeControlDto; 
		
	}
	
	@RequestMapping(value = "admin/marketing_vctakers", method = RequestMethod.GET)
	public @ResponseBody PrivilegeControlDto getMarketingVcTakers() {
		logger.info("+++++ Getting Marketeres and Vendor Call Taker +++++");
		PrivilegeControlDto privilegeControlDto = userService.getMarketerVcs();
		return privilegeControlDto;
	}
	
	
	@RequestMapping(value = "admin/marketing_vctakers", method = RequestMethod.POST)
	public @ResponseBody PrivilegeControlDto manageMarketingVcTakers(@RequestBody PrivilegeControlDto privilegeControlDto) {
		logger.info("+++++ Setting the role of Marketing & Vendor Call Takers +++++");
		
		userService.manageMarketerVcs(privilegeControlDto);
		
		return privilegeControlDto;
		
	}
	
	@RequestMapping(value = "admin/create-technology", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody Technology createTechnogoy(@RequestBody Technology technology) {
		logger.info("+++++ Creating the Technology ++++++");
		return	technologyService.createTechnology(technology);
		
	}
	
	@RequestMapping(value = "admin/tree-view-user", method = RequestMethod.GET)
	public @ResponseBody TreeViewDto getTreeUsers() {
		logger.info("+++ Getting the User Tree View +++++++");
		TreeViewDto mainParent = new TreeViewDto("Admin"); 
		List<User> marketers = userService.getUsers(Role.ROLE_MARKETING);
		
		for(User user: marketers){
			TreeViewDto marketerNode  = new TreeViewDto(user.getFullName() + " "+"[Marketer]");
			
			for(UserControl userControl : user.getControllableUsers()) {
				TreeViewDto vcNode = new TreeViewDto(userControl.getVendorCallTaker().getFullName()+ " "+"[VC Taker]");
				List<Candidate> candidates = candidateService.findAll(userControl.getVendorCallTaker().getId()); 
				
				for(Candidate candidate : candidates) {
					TreeViewDto candidateNode = new TreeViewDto(candidate.getFullName()+ " "+"[Candidate]");
					vcNode.addChild(candidateNode);
				}
				
				marketerNode.addChild(vcNode);
			}
			
			mainParent.addChild(marketerNode);
		}
		
		return mainParent;
	}
	


}
