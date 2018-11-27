package com.redq.shining.mapper;

import com.redq.shining.common.BaseMapper;
import com.redq.shining.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ahlon
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where mobile = #{mobile}")
    User findByMobile(@Param("mobile") String mobile);

}
