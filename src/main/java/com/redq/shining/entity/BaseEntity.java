package com.redq.shining.entity;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class BaseEntity {

    @Id
    private Long id;

    private Date createdAt;

    private Long createdBy;

    private Date updatedAt;

    private Long updatedBy;

    private boolean deleted;

}
