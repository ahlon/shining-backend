package com.redq.shining.mapper;

import com.redq.shining.common.BaseMapper;
import com.redq.shining.entity.Zone;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ZoneMapper extends BaseMapper<Zone> {

}