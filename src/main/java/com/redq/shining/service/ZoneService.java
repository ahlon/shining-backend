package com.redq.shining.service;

import com.redq.shining.common.BaseService;
import com.redq.shining.entity.Zone;

import java.util.List;

public interface ZoneService extends BaseService<Zone> {

    List<Zone> findChildren(Long zoneId);

    List<Zone> findParents(Long zoneId);

    // List<Zone> getAll(Pageable pager);
}
