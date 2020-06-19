package com.cubic.ipm.dao;

import java.util.List;

import com.cubic.ipm.model.Technology;

public interface TechnologyDaoService extends BaseDaoService<Technology>{
	public List<Technology> getAllTechnlogies();
	public Technology createTechnology(Technology technology);
	
}
