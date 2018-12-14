package com.redq.shining.controller;

import com.redq.shining.common.ResponseResult;
import com.redq.shining.entity.Zone;
import com.redq.shining.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ahlon
 */
@RestController
@RequestMapping(value = "/zone")
public class ZoneController {

	@Autowired
    private ZoneService zoneService;
	
	private static long ROOT_ZONE_ID = 1L;

    @GetMapping("/view")
    public ResponseResult<List<Zone>> view(Long id) {
        Zone zone = zoneService.findById(id);
        return ResponseResult.success(zone);
    }
	
	@GetMapping("/roots")
    public ResponseResult<List<Zone>> roots() {
		List<Zone> zones = zoneService.findChildren(ROOT_ZONE_ID);
		return ResponseResult.success(zones);
    }

    @GetMapping("/children")
    public ResponseResult<List<Zone>> children(Long id) {
		List<Zone> zones = zoneService.findChildren(id);
        return ResponseResult.success(zones);
    }
	
	@GetMapping("/parents")
    public ResponseResult<List<Zone>> parents(Long id) {
		List<Zone> zones = zoneService.findParents(id);
        return ResponseResult.success(zones);
    }

}
