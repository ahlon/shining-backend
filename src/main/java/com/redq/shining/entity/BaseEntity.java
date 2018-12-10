package com.redq.shining.entity;

import lombok.Data;
import org.springframework.context.annotation.Primary;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.util.Date;

@Data
public class BaseEntity {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private Date createdAt;

    private Long createdBy;

    private Date updatedAt;

    private Long updatedBy;

    private boolean deleted;

}
