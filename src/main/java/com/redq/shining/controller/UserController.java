package com.redq.shining.controller;

import com.redq.shining.entity.User;
import com.redq.shining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/view")
    public User findByMobile(Long id) {
        return userService.findById(id);
    }

    @GetMapping("/view-by-mobi")
    public User findByMobile(String mobile) {
        return userService.findByMobile(mobile);
    }

    @GetMapping("/list")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/remove")
    public int remove(Long id) {
        return userService.remove(id);
    }

}
