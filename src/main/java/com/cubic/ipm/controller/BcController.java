package com.cubic.ipm.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cubic.ipm.model.Candidate;
import com.cubic.ipm.service.CandidateService;
/*import com.cubic.ipm.service.CandidateService;
*/
@Controller
public class BcController {

	private Logger logger = Logger.getLogger(BcController.class); 

	@Autowired
	private CandidateService candidateService;
	
	/*@RequestMapping(value = "candidate/search", method = RequestMethod.GET)
	public @ResponseBody Candidate searchCandidate(@RequestBody Candidate candidate) {
		logger.info("+++++ Searching Candidate +++++");
		candidateService.findByCandidateName(candidate);
		return candidate;
	}*/
	
	@RequestMapping(value = "bchecker/all_candidate", method = RequestMethod.GET)
	public @ResponseBody List<Candidate>  getAllCandidate(){
		return candidateService.getAllCandidate();
		/*List<Candidate> candidates= new ArrayList<>();
		Candidate candidate= new Candidate();
		Candidate candidate1= new Candidate();
		
		Phone phone= new Phone();
		Phone phone1= new Phone();

		phone.setAreaCode("123");
		phone.setPrefixValue("123");
		phone.setNumber("4567");
		
		phone1.setAreaCode("641");
		phone1.setPrefixValue("789");
		phone1.setNumber("9807");
		
		candidate.setFirstName("Pradeep");
		candidate.setLastName("Basnet");
		//candidate.setPhone(phone);

		candidate1.setFirstName("Surendra");
		candidate1.setLastName("Jnawali");
		//candidate1.setPhone(phone1);
		
		candidates.add(candidate);
		candidates.add(candidate1);
		return candidates;*/
	}
		
}
