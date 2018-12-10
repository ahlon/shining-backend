package com.redq.shining.controller;

import com.redq.shining.common.ResponseResult;
import com.redq.shining.entity.Shining;
import com.redq.shining.service.ShiningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ahlon
 */
@RestController
@RequestMapping(value = "/shining")
public class ShiningController {

    @Autowired
    private ShiningService shiningService;

    @PostMapping("/save")
    public ResponseResult<Shining> save(String content) {
        Shining shining = new Shining();
        shining.setContent(content);
        int i = shiningService.save(shining);
        return ResponseResult.success(shining);
    }

    @GetMapping("/list")
    public ResponseResult<List<Shining>> list() {
        List<Shining> data = shiningService.findAll();
        return ResponseResult.success(data);
    }

    @GetMapping("/remove")
    public ResponseResult<Boolean> remove(Long id) {
        shiningService.remove(id);
        return ResponseResult.success(true);
    }

}
