package com.redq.shining.entity;

import lombok.Data;

@Data
public class Zone extends BaseEntity {

    private String name;

    private Long parentId;

    private String path;

}
