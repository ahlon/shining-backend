package com.redq.shining.service.impl;

import com.redq.shining.common.BaseMapper;
import com.redq.shining.common.BaseServiceImpl;
import com.redq.shining.entity.User;
import com.redq.shining.mapper.UserMapper;
import com.redq.shining.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ahlon
 */
@Log
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseMapper getMapper() {
        return this.userMapper;
    }

    @Override
    public User findByMobile(String mobile) {
        log.info("mobile: " + mobile);
        return userMapper.findByMobile(mobile);
    }

}
