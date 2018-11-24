package com.redq.shining.service;

import com.redq.shining.common.BaseService;
import com.redq.shining.entity.User;

public interface UserService extends BaseService<User> {

    User findByMobile(String mobile);

}
