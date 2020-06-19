package com.cubic.ipm.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.cubic.ipm.model.Candidate;

public interface CandidateService   {
	Candidate createCandidate(Candidate candidateObject,MultipartFile file);
    List<Candidate> findAll(String vcEmail);
	List<Candidate> getAllCandidate();
	List<Candidate> findAll(Long vcId);
}
