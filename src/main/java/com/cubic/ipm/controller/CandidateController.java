package com.cubic.ipm.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.cubic.ipm.model.Role;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cubic.ipm.model.Candidate;
import com.cubic.ipm.model.Technology;
import com.cubic.ipm.service.CandidateService;
import com.cubic.ipm.service.TechnologyService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class CandidateController {
private Logger logger = Logger.getLogger(CandidateController.class);

	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private TechnologyService technologyService;
@Autowired
private UserDetailsService userDetailsService;
	
	@RequestMapping(value = {"admin/create-candidate","bchecker/create-candidate"}, method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE/*, produces = { MediaType.APPLICATION_JSON_VALUE }*/)
	public @ResponseBody Candidate createUser(@RequestParam("candidate")String candidate,@RequestParam("file") MultipartFile file) throws JsonParseException, JsonMappingException, IOException{
		
		
		logger.info("+++++ Creating the User ++++++"+ candidate);
		Candidate candidateObject= new ObjectMapper().readValue(candidate, Candidate.class);
		return candidateService.createCandidate(candidateObject,file);
		
        } 
		
//		System.out.println(candidate1);
		//candidateService.createCandidate(candidate);
	
	@RequestMapping("vcs/mycandidates")
	@ResponseBody
		public List<Candidate> getAll(Principal principal){
		return candidateService.findAll(principal.getName());
	}

	
	@RequestMapping(value = {"bchecker/get-technology", "admin/get-technology"}, method = RequestMethod.GET)
	public @ResponseBody List<Technology> getAllTechnologies() {
		//logger.info("+++++ Creating the User ++++++");
	    return technologyService.getAllTechnologies();
	}

}
