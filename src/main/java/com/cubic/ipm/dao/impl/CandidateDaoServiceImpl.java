package com.cubic.ipm.dao.impl;

import com.cubic.ipm.dao.CandidateDaoService;
import com.cubic.ipm.model.Candidate;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CandidateDaoServiceImpl extends BaseDaoServiceImpl<Candidate>
        implements CandidateDaoService {

    @Override
    public List<Candidate> findAll(String vcEmail) {
        Query query = getCurrentSession()
                .createQuery("from Candidate c where c.vcTaker.email=:email");
        query.setParameter("email", vcEmail);
        return query.list();
    }

	@Override
	public List<Candidate> findAll(Long vcId) {
		 Query query = getCurrentSession()
	                .createQuery("from Candidate c where c.vcTaker.id=:vcId");
	        query.setParameter("vcId", vcId);
	        return query.list();
	}
}
