package com.cubic.ipm.service.impl;

import com.cubic.ipm.dao.VcDao;
import com.cubic.ipm.enums.Flags;
import com.cubic.ipm.model.Role;
import com.cubic.ipm.model.User;
import com.cubic.ipm.service.VcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by abc on 3/16/16.
 */
@Service
@Transactional
public class VcServiceImpl implements VcService {

    @Autowired
    VcDao vcDao;

    @Override
    public List<User> findAll(Role role) {
        return vcDao.findAll(role);
    }

    @Override
    public User create(User user) {
        return vcDao.save(user);
    }

    @Override
    public boolean delete(long vcId) {
        User user = vcDao.find(vcId);
        if (user == null) throw new IllegalArgumentException("No such user");
        user.setFlag(Flags.DELETED);
        user = vcDao.update(user);
        return user.getFlag().equals(Flags.DELETED);
    }

    @Override
    public User edit(User user) {
        return vcDao.update(user);
    }

    @Override
    public User find(long vcId, Role role) {
        User user = vcDao.find(vcId);
        return user.getRole() == role ? user : null;
    }

    @Override
    public List<User> findDeleted(Role role, Flags flag) {
        return vcDao.findDeleted(role,flag);
    }

    @Override
    public User enable(long vcId) {
        User user = vcDao.find(vcId);
        if (user == null) throw new IllegalArgumentException("No such user");
        user.setFlag(Flags.ACTIVE);
        return vcDao.update(user);
    }
}
