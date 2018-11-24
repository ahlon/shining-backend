package com.redq.shining.entity;

import lombok.Data;

@Data
public class User extends BaseEntity {

    private String mobile;

    private String nickname;

    private String password;

    private String email;

    private boolean gender;

    private UserStatus status;

}