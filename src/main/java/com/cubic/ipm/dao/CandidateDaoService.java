package com.cubic.ipm.dao;

import com.cubic.ipm.model.Candidate;

import java.util.List;

public interface CandidateDaoService extends BaseDaoService<Candidate> {

    List<Candidate> findAll(String vcEmail);
    List<Candidate> findAll(Long vcId);
}
