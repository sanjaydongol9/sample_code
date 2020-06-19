package com.cubic.ipm.dao.impl;

import com.cubic.ipm.dao.VcDao;
import com.cubic.ipm.enums.Flags;
import com.cubic.ipm.model.Role;
import com.cubic.ipm.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by abc on 3/16/16.
 */
@Repository
public class VcDaoImpl extends BaseDaoServiceImpl<User> implements VcDao {
    @Override
    public List<User> findAll(Role role) {
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("role", role));
        return criteria.list();
    }

    @Override
    public List<User> findDeleted(Role role, Flags flag) {
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("role", role)).add(Restrictions.eq("flag", flag));
        return criteria.list();
    }
}
