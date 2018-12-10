package com.redq.shining.controller;

import com.redq.shining.common.ResponseResult;
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
    public ResponseResult<User> findByMobile(Long id) {
        User user = userService.findById(id);
        return ResponseResult.success(user);
    }

    @GetMapping("/find-by-mobile")
    public ResponseResult<User> findByMobile(String mobile) {
        User user = userService.findByMobile(mobile);
        return ResponseResult.success(user);
    }

    @GetMapping("/list")
    public ResponseResult<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseResult.success(users);
    }

    @GetMapping("/search")
    public ResponseResult<List<User>> search() {
        List<User> users = userService.findAll();
        return ResponseResult.success(users);
    }

    @GetMapping("/remove")
    public ResponseResult<Integer> remove(Long id) {
        int i = userService.remove(id);
        if (i == 1) {
            return ResponseResult.success(new Integer(i));
        } else if (i == 0) {
            return ResponseResult.fail(new Integer(i), "不存在id为" + id + "的用户");
        } else {
            // exception
            throw new RuntimeException("删除失败!");
        }
    }

}
