package com.cubic.ipm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.ipm.dao.TechnologyDaoService;
import com.cubic.ipm.enums.Flags;
import com.cubic.ipm.model.Technology;
import com.cubic.ipm.service.TechnologyService;

@Service
@Transactional
public class TechnologyServiceImpl implements TechnologyService{
	
	@Autowired
	TechnologyDaoService technologyDaoService;

	@Override
	public List<Technology> getAllTechnologies(){ 	
		return technologyDaoService.getAllTechnlogies();
	}

	@Override
	public Technology findTechnologyById(long id) {
		return technologyDaoService.find(id);
		
	}
	
	public Technology createTechnology(Technology technology){
		technology.setFlag(Flags.ACTIVE);
		return technologyDaoService.createTechnology(technology);
	}


}
