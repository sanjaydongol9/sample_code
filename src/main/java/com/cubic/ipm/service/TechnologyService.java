package com.cubic.ipm.service;

import java.util.List;

import com.cubic.ipm.model.Technology;

public interface TechnologyService {
   Technology createTechnology(Technology technogy);
   List<Technology> getAllTechnologies();
   Technology findTechnologyById(long id);
 
}
