package com.redq.shining.service.impl;

import com.redq.shining.common.BaseMapper;
import com.redq.shining.common.BaseServiceImpl;
import com.redq.shining.entity.Shining;
import com.redq.shining.mapper.ShiningMapper;
import com.redq.shining.service.ShiningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiningServiceImpl extends BaseServiceImpl<Shining> implements ShiningService {

    @Autowired
    private ShiningMapper shiningMapper;

    @Override
    public BaseMapper<Shining> getMapper() {
        return this.shiningMapper;
    }


}
