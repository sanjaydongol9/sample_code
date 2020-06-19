package com.cubic.ipm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cubic.ipm.dao.CandidateDaoService;
import com.cubic.ipm.dao.TechnologyDaoService;
import com.cubic.ipm.model.Candidate;
import com.cubic.ipm.service.CandidateService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;



@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	CandidateDaoService candidateDaoService;
	
	@Autowired
	TechnologyDaoService technologyDaoService;
	@Override
	public Candidate createCandidate(Candidate candidateObject,MultipartFile file) {

		String name="";
		BufferedOutputStream stream=null;
		if (!file.isEmpty()) {
		
            try {
                byte[] bytes = file.getBytes();
                candidateObject.getTechnology();
                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();
                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator +name);
               
               candidateObject.setResumeLocation(serverFile.getAbsolutePath());
               candidateObject.setTechnology(technologyDaoService.find(candidateObject.getTechnology().getId()));
               Candidate result=candidateDaoService.save(candidateObject); 
              
                stream = new BufferedOutputStream(
                       new FileOutputStream(new File(dir.getAbsolutePath()
                               + File.separator +result.getId())));
               System.out.print("---------------"+result);
               stream.write(bytes);
               stream.close();
               return candidateObject;
                
            } catch (Exception e) {
                return candidateObject;
            }finally{
            	try {
					stream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        } 
		
//		System.out.println(candidate1);
		//candidateService.createCandidate(candidate);
		return candidateObject;
  
	}

	@Override
	public List<Candidate> getAllCandidate(){
		return candidateDaoService.findAll();
	}

    @Override
    public List<Candidate> findAll(String vcEmail) {
        return candidateDaoService.findAll(vcEmail);
    }

	@Override
	public List<Candidate> findAll(Long vcId) {
		return candidateDaoService.findAll(vcId);
	}
}
