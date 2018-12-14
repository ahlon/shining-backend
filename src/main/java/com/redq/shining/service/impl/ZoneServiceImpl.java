package com.redq.shining.service.impl;

import com.redq.shining.common.BaseMapper;
import com.redq.shining.common.BaseServiceImpl;
import com.redq.shining.common.BizException;
import com.redq.shining.entity.Zone;
import com.redq.shining.mapper.ZoneMapper;
import com.redq.shining.service.ZoneService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ahlon
 */
@Log
@Service
public class ZoneServiceImpl extends BaseServiceImpl<Zone> implements ZoneService {

    @Autowired
    private ZoneMapper zoneMapper;

    @Override
    public BaseMapper<Zone> getMapper() {
        return this.zoneMapper;
    }

    @Override
    public List<Zone> findChildren(Long zoneId) {
        Example example = new Example(Zone.class);
        example.createCriteria().andEqualTo("parentId", zoneId);
        return zoneMapper.selectByExample(example);
    }

    @Override
    public List<Zone> findParents(Long zoneId) {
        Zone zone = zoneMapper.selectByPrimaryKey(zoneId);
        if (zone == null) {
            throw new BizException("Can not find zone by id:" + zoneId);
        }

        List<Zone> zones = new ArrayList<Zone>();
        boolean ctn = true;

        while (ctn) {
            if (zone.getParentId() != null) {
                Zone parent = zoneMapper.selectByPrimaryKey(zone.getParentId());
                zones.add(parent);
                zone = parent;
            } else {
                ctn = false;
            }
        }
        Collections.reverse(zones);
        return zones;
    }
}
