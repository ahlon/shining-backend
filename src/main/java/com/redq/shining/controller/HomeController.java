package com.redq.shining.controller;

import com.redq.shining.common.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ahlon
 */
@RestController
@RequestMapping(value = "/home")
public class HomeController {

    @GetMapping("/hello")
    public ResponseResult<String> hello() {
        return ResponseResult.success("hello world");
    }

}
