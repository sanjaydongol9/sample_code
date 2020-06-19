package com.cubic.ipm.dao;

import com.cubic.ipm.enums.Flags;
import com.cubic.ipm.model.Role;
import com.cubic.ipm.model.User;

import java.util.List;

/**
 * Created by abc on 3/16/16.
 */
public interface VcDao extends BaseDaoService<User> {
    List<User> findAll(Role role);

    List<User> findDeleted(Role role, Flags flag);
}
