package com.cubic.ipm.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cubic.ipm.dao.TechnologyDaoService;
import com.cubic.ipm.model.Candidate;
import com.cubic.ipm.model.Technology;
import com.cubic.ipm.model.User;


@Repository
public class TechnologyDaoServiceImpl  extends BaseDaoServiceImpl<Technology>
implements TechnologyDaoService {
	
	
	
	@Override
	public List<Technology> getAllTechnlogies() {
		return  findAll();
	}

	@Override
	public Technology createTechnology(Technology technology) {
		return save(technology);
	}
}
