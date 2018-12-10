package com.redq.shining.mapper;

import com.redq.shining.common.BaseMapper;
import com.redq.shining.entity.Shining;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ahlon
 */
@Repository
@Mapper
public interface ShiningMapper extends BaseMapper<Shining> {

}
