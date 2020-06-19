package com.cubic.ipm.service;

import com.cubic.ipm.enums.Flags;
import com.cubic.ipm.model.Role;
import com.cubic.ipm.model.User;

import java.util.List;

/**
 * Created by abc on 3/16/16.
 */
public interface VcService {
    List<User> findAll(Role role);

    User create(User user);

    boolean delete(long vcId);

    User edit(User user);

    User find(long vcId, Role role);

    List<User> findDeleted(Role role, Flags flag);

    User enable(long vcId);
}
